package com.linkedbear.spring.proxy.a_basic;

public class Client {
    
    public static void main(String[] args) throws Exception {
        Player player = new Player("郝武辽");
        Partner partner = new Partner("肖洁洁");
        
        partner.receiveMoney(200);
        partner.playWith(player);
    }
}
