package euler;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Problem031 extends ProblemBase {
	
	private final int limit = 200;
	
	private Set<CoinContainer> configurations;
	
	public Problem031() {
		super(31, "Coin sums");
		configurations = new HashSet<>();
	}

	@Override
	protected String getSolution() {
		return Integer.toString(configurations.size());
	}

	@Override
	protected void solve() {
		LinkedList<Coin> coins = new LinkedList<>();
		
		// To prevent errors with floating points I'll use all units in pences
		for (Coin coin : Coin.values()) {
			coins.addLast(coin);
		}
		
		/*
		 * I will be using a greedy approach:
		 * Take the first fitting coin, then make as many configurations with the remaining coins
		 * Once all configurations are exhausted: remove the first used coin and repeat 
		 */
		addConfigurations(coins, new CoinContainer());
	}
	
	private void addConfigurations(LinkedList<Coin> coins, CoinContainer coinContainer) {
		for(Coin coin : coins) {
			int addedCoins = 0;
			while (coinContainer.countSum() + coin.pence <= limit) {
				coinContainer.addCoin(coin);
				addedCoins += 1;
			}
			
			if (coinContainer.countSum() == limit) {
				configurations.add(coinContainer.clone());
			}
			
			@SuppressWarnings("unchecked")
			LinkedList<Coin> newCoins = (LinkedList<Coin>) coins.clone();
			newCoins.removeFirst();
			
			while (addedCoins > 0) {
				addConfigurations(newCoins, coinContainer.clone());
				coinContainer.removeLastCoin();
				addedCoins--;
			}
		}
	}
	
	private class CoinContainer implements Cloneable {
		
		private Map<Coin, Integer> coins;
		private Stack<Coin> addHistory;
		
		public CoinContainer() {
			coins = new EnumMap<>(Coin.class);
			addHistory = new Stack<>();
		}
		
		public void addCoin(Coin coin) {
			addHistory.push(coin);
			
			int coinCount = 1;
			
			if (coins.containsKey(coin)) {
				coinCount += coins.get(coin);
			}
			
			coins.put(coin, coinCount);
		}
		
		public void removeLastCoin() {
			Coin coin = addHistory.pop();
			int coinCount = -1;
			
			if (coins.containsKey(coin)) {
				coinCount += coins.get(coin);
			} else {
				throw new IllegalArgumentException(String.format("Removing non existing coin: %s", coin));
			}
			
			if (coinCount == 0) {
				coins.remove(coin);
			} else {
				coins.put(coin, coinCount);
			}
		}
		
		public int countSum() {
			return coins.entrySet().stream()
					.mapToInt(e -> e.getKey().pence * e.getValue())
					.sum();
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public CoinContainer clone() {
			CoinContainer container = new CoinContainer();
			coins.entrySet().forEach(e -> {
				for (int i = 0; i < e.getValue(); i++) {
				container.addCoin(e.getKey());
				}
			});
			container.addHistory = (Stack<Coin>) container.addHistory.clone();
			
			return container;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((coins == null) ? 0 : coins.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CoinContainer other = (CoinContainer) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (coins == null) {
				if (other.coins != null)
					return false;
			} else if (!coins.equals(other.coins))
				return false;
			return true;
		}

		private Problem031 getOuterType() {
			return Problem031.this;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(getClass().getSimpleName());
			sb.append("[");
			coins.entrySet().stream().
				sorted((a, b) -> a.getKey().pence - b.getKey().pence).
				forEach(e -> {
					sb.append(e.getValue());
					sb.append("x ");
					sb.append(e.getKey().pence);
					sb.append(", ");
				}
			);
			
			if (coins.size() > 0) {
				sb.delete(sb.length() - 2, sb.length() - 1);
			}
			
			sb.append("]");
			return sb.toString();
		}
		
	}
	
	private enum Coin {
		ONE_PENCE(1),
		TWO_PENCE(2),
		FIVE_PENCE(5),
		TEN_PENCE(10),
		TWENTY_PENCE(20),
		FIFTY_PENCE(50),
		ONE_POUND(100),
		TWO_POUND(200);
		
		public final int pence;
		
		private Coin(int pence) {
			this.pence = pence;
		}
		
	}

}
