package com.jmu.javaweb_jibite.controller;

import com.alibaba.fastjson.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

/**
 * Created by ShaoJ
 * Date: 2020/10/12
 * Time: 23:25
 */
@RestController
public class IntegrationController {

        private double func(double x){
                return x*pow(E,-x);
        }

        @RequestMapping("integration")
        public double getIntegration(String parm){
                //x*e-x
                Map<String,String> map ;
                double x,a,b;
                double y=0.0;
                List<Object> json =JSON.parseArray(parm);
                String idea=json.get(0).toString();
                Gson gson = new Gson();
                map = gson.fromJson(idea, new TypeToken<HashMap<String,String>>(){}.getType());
                String valueOfA = map.get("value");
                a=Double.parseDouble(valueOfA);
                idea=json.get(1).toString();
                map = gson.fromJson(idea, new TypeToken<HashMap<String,String>>(){}.getType());
                String valueOfB = map.get("value");
                b=Double.parseDouble(valueOfB);
                double eps = 0.0001;
                int n = 512;   //初始分割
                double step = (b - a) / n;
                double s1,s2,diff;
                s1=0.0;
                for (int i = 0; i < n; i++)
                {
                        s1 += func(a + step * i)*step;   //计算初始面积
                }
                do
                {
                        n = 2 * n;    //分割加倍
                        s2=s1/2;
                        step = (b - a) / n;
                        for (int i = 1; i < n; i+=2) {
                                s2+=func(a + step * i)*step;
                        }
                        diff = (s1 - s2)>0?(s1-s2):(s2-s1);      //计算两次迭代的结果差值
                        s1 = s2; //更新迭代变量
                } while (diff >= eps);
                return s1;
        }
}
