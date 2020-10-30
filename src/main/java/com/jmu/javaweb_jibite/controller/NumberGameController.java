package com.jmu.javaweb_jibite.controller;

import com.jmu.javaweb_jibite.service.impl.NumberGameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;


/**
 * Created by ShaoJ
 * Date: 2020/10/17
 * Time: 22:44
 */
@RestController
public class NumberGameController {
    @Autowired
    private NumberGameServiceImpl game;

    private int times=0;

    @RequestMapping("setNumber")
    public void setNumber(HttpServletRequest req){
        HttpSession session = req.getSession();
        StringBuilder num = new StringBuilder();
        int correctNum;
        int a;
        while (true) {
            a = (int)(10*Math.random());
            //第一位不能为0
            if(num.length()<1){
                while(true) {
                    if (a == 0) {
                        a = (int) (10 * Math.random());
                    } else {
                        break;
                    }
                }
            }
            //检查重复
            boolean isRepeat;
            while(true){
                isRepeat = false;
                for (int i=0; i<num.length();i++) {
                    if (num.charAt(i)==(a+'0')) {
                        a = (int) (10 * Math.random());
                        isRepeat=true;
                        break;
                    }
                }
                if(!isRepeat)
                    break;
            }
            num.append(a);
            if(num.length()>3)
                break;
        }
        correctNum=Integer.parseInt( num.toString());
        session.setAttribute("correctNumber",correctNum);
        System.out.println(session.getAttribute("correctNumber"));
    }

    @RequestMapping("isCorrect")
    public int[] getResult(HttpServletRequest req,String input){
        HttpSession session = req.getSession();
        int correctNumber = (int) session.getAttribute("correctNumber");
        int answer=Integer.parseInt(input);
        game.setAnswer(correctNumber);
        List<Integer> result = game.getResult(answer);
        times++;
        int [] res = {result.get(0),result.get(1),times};
        if(result.get(0)==4){
            times=0;
        }
        return res;
    }
}
