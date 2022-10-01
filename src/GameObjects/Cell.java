package GameObjects;

public class Cell {
	protected int Value;
	
	protected int WinWhenStarted;
	
	public Cell() {
		this.Value = 0;
		this.WinWhenStarted = 0;
	}
	
	public int GetValue() {
		return this.Value;
	}
	
	public void SetValue(int value) {
		this.Value = value;
	}
}
