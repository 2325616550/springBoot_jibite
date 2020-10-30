package com.jmu.javaweb_jibite.service.impl;

import com.jmu.javaweb_jibite.service.NumberGameService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

/**
 * Created by ShaoJ
 * Date: 2020/10/21
 * Time: 16:16
 */
@Service
public class NumberGameServiceImpl implements NumberGameService {
    private int answer;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public List<Integer> getResult(int input){
        List<Integer> result=new ArrayList<>(2); //0-A 1-B
        int numOfA=0,numOfB=0;
        result.add(numOfA);
        result.add(numOfB);
        int correctNumber,answerNumber;
        for (int i = 3; i >=0; i--) {
            correctNumber = (int) (answer/pow(10,i)%10);
            answerNumber = (int) (input/pow(10,i)%10);
//            System.out.println(i + "---->" + correctNumber + "---->" + answerNumber);
            if(correctNumber==answerNumber) {
                numOfA++;
                result.set(0,numOfA);
            } else{
                for (int j = 0; j <=3; j++) {
                    if(j==i)
                        continue;
                    else{
                        correctNumber = (int) (answer/pow(10,j)%10);
                        if(answerNumber==correctNumber){
                            numOfB++;
                            result.set(1,numOfB);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
