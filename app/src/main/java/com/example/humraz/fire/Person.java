package com.example.humraz.fire;

/**
 * Created by humra on 8/16/2016.
 */
public class Person {
    private String name;
private String att;
long stackId;
        public Person() {
      /*Blank default constructor essential for Firebase*/
        }
        public Person(String a)
        {

        }
        //Getters and setters
        public String getName() {
            return name;
        }
        public long getStackId() { return stackId; }
        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return att;
        }

        public void setAddress(String att) {
            this.att = att;
        }
        @Override
        public String toString() {

            return name+"  "+att;
        }
}