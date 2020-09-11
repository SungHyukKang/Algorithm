package ICT;

import java.util.*;


public class ProfitTarget {
	
	public static int stockPairs(List<Integer> stocksProfit , long target) {
		Collections.sort(stocksProfit);
		HashMap<Integer,Integer> hsmap = new HashMap<>();
		for(int i  = 0 ;i<stocksProfit.size();i++) {
			if(stocksProfit.get(i)>target/2)
				break;
			if(stocksProfit.get(i)==-1) 
				continue;
				for(int j=stocksProfit.size()-1;j>i;j--) {
					if(stocksProfit.get(j)!=-1&&stocksProfit.get(i)+stocksProfit.get(j)<target) {
						break;
					}
					if(stocksProfit.get(j)!=-1&&stocksProfit.get(i)+stocksProfit.get(j)==target) {
						hsmap.put(stocksProfit.get(i), stocksProfit.get(j));
						stocksProfit.set(i, -1);
						stocksProfit.set(j, -1);
						break;
					}
				}
		}
		return hsmap.size();			
		}
	
	public static void main(String[] args) {
		List<Integer> stocksProfit = new ArrayList<>();
		stocksProfit.add(91);
		stocksProfit.add(407);
		stocksProfit.add(1152);
		stocksProfit.add(403);
		stocksProfit.add(1419);
		stocksProfit.add(689);
		stocksProfit.add(1029);
		stocksProfit.add(108);
		stocksProfit.add(128);
		stocksProfit.add(1307);
		stocksProfit.add(300);
		stocksProfit.add(775);
		stocksProfit.add(622);
		stocksProfit.add(730);
		stocksProfit.add(978);
		stocksProfit.add(526);
		stocksProfit.add(943);
		stocksProfit.add(127);
		stocksProfit.add(566);
		stocksProfit.add(869);
		stocksProfit.add(715);
		stocksProfit.add(983);
		stocksProfit.add(820);
		stocksProfit.add(1394);
		stocksProfit.add(901);
		stocksProfit.add(606);
		stocksProfit.add(497);
		stocksProfit.add(98);
		stocksProfit.add(1222);
		stocksProfit.add(843);
		stocksProfit.add(600);
		stocksProfit.add(1153);
		stocksProfit.add(302);
		stocksProfit.add(1450);
		stocksProfit.add(1457);
		stocksProfit.add(973);
		stocksProfit.add(1431);
		stocksProfit.add(217);
		stocksProfit.add(936);
		stocksProfit.add(958);
		stocksProfit.add(1258);
		stocksProfit.add(970);
		stocksProfit.add(1155);
		stocksProfit.add(1061);
		stocksProfit.add(1341);
		stocksProfit.add(657);
		stocksProfit.add(333);
		stocksProfit.add(1151);
		stocksProfit.add(790);
		stocksProfit.add(101);
		stocksProfit.add(588);
		stocksProfit.add(263);
		stocksProfit.add(101);
		stocksProfit.add(534);
		stocksProfit.add(747);
		stocksProfit.add(405);
		stocksProfit.add(585);
		stocksProfit.add(111);
		stocksProfit.add(849);
		stocksProfit.add(695);
		stocksProfit.add(1256);
		stocksProfit.add(1508);
		stocksProfit.add(139);
		stocksProfit.add(336);
		stocksProfit.add(1430);
		stocksProfit.add(615);
		stocksProfit.add(1295);
		stocksProfit.add(550);
		stocksProfit.add(783);
		stocksProfit.add(575);
		stocksProfit.add(992);
		stocksProfit.add(709);
		stocksProfit.add(828);
		stocksProfit.add(1447);
		stocksProfit.add(1457);
		stocksProfit.add(738);
		stocksProfit.add(1024);
		stocksProfit.add(529);
		stocksProfit.add(406);
		stocksProfit.add(164);
		stocksProfit.add(994);
		stocksProfit.add(1008);
		stocksProfit.add(50);
		stocksProfit.add(811);
		stocksProfit.add(564);
		stocksProfit.add(580);
		stocksProfit.add(952);
		stocksProfit.add(768);
		stocksProfit.add(863);
		stocksProfit.add(1225);
		stocksProfit.add(251);
		stocksProfit.add(1032);
		stocksProfit.add(1460);
		
		System.out.println(ProfitTarget.stockPairs(stocksProfit, 1558));
	}

}
