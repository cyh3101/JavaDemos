package com.cyh.demos.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShowHand {

	public final int PLAY_NUM = 5;
	private String[] types = {"方块","草花","红心","黑桃"};
	private String[] values = {"2","3","4","5","6","7","8","9","10",
			"J","Q","K","A"};
	//初始化剩下的cards
	private List<String> cards = new LinkedList<String>();
	private String[] players = new String[PLAY_NUM];
	private List<String>[] playersCards = new List[PLAY_NUM];
	
	//初始化cards，放入52张扑克牌
	public void initCards(){
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cards.add(types[i] + values[j]);
			}	
		}
		Collections.shuffle(cards);
	}
	
	//初始化玩家
	public void initPlayers(String... names){
		if(names.length > PLAY_NUM || names.length < 2){
			System.out.println("玩家数量有误,请重新输入");
		}
		for (int i = 0; i < names.length; i++) {
			players[i] = names[i];
		}
	}
	
	//初始化玩家的牌
	public void initPlayerCards() {
		for (int i = 0; i < players.length; i++) {
			if(players[i] != null && !players[i].equals("")){
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	
	//输入全部牌
	public void showAllCards(){
		for(String card : cards){
			System.out.println(card);
		}
	}
	
	//给玩家分配牌
	public void deliverCard(String first) {
		int position = ArrayUtils.search(players,first);
		//为first玩家以后的玩家分配牌
		for (int i = position; i < players.length; i++) {
			if(players[i] != null){
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		//为first玩家以前的玩家分配牌
		for (int i = 0; i < position; i++) {
			if(players[i] != null){
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	//输出玩家手上的牌
	public void showPlayerCards() {
		for (int i = 0; i < players.length; i++) {
			if(players[i] != null){
				System.out.println(players[i] + ":");
				for (int j = 0; j < playersCards[i].size(); j++) {
					System.out.println(playersCards[i].get(j));
				}
			}
			System.out.println();
		}
	}
	
 	public static void main(String[] args) {
		ShowHand showHand = new ShowHand();
		showHand.initPlayers("电脑玩家1","电脑玩家2");
		showHand.initCards();
		showHand.initPlayerCards();
		//输出生成的全部的卡牌
		//showHand.showAllCards();
		
		showHand.deliverCard("电脑玩家1");
		showHand.showPlayerCards();
		
		showHand.deliverCard("电脑玩家2");
		showHand.showPlayerCards();

	}

}
