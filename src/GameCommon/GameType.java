package GameCommon;

public enum GameType {
	TicTacToe(1),
	OrderAndChaos(2);
	
	private int value;

    private GameType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
