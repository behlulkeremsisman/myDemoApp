package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    
    public static ArrayList findEvenNumbers(ArrayList<Integer> array, int e, ArrayList<Integer> evenNumbersArray) {
      if (array == null)
          System.out.println("Please add some numbers.");

      for (int elt : array) {
          if (elt < e){
              if(elt%2==0)
                  evenNumbersArray.add(elt);
          }
      }
      return evenNumbersArray;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "Finding even numbers less than input 2");
        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
            
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
            
         java.util.ArrayList<Integer> resultList = new java.util.ArrayList<>();
         resultList = App.findEvenNumbers(inputList, input2AsInt, resultList);
         Map map = new HashMap();
            
          map.put("result", resultList);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

