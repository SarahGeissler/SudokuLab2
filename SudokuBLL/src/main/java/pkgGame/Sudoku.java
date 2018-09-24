package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
	private int iSize;
	private int iSqrtSize;
	
	
	public Sudoku(int iSize) {
		double SqrtSize = Math.sqrt(iSize);
		try {
		if (iSize%SqrtSize == 0) {
			this.iSize = iSize;
			this.iSqrtSize = (int) SqrtSize;
	    }
		else {
		catch(exception e) {
			throw e;
		}
		}
	}
	}
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	protected int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	protected int[] getRegion(int r)
	{
		int[] reg = new int[super.getLatinSquare().length];
		
		int i = (r % iSqrtSize) * iSqrtSize;
		int j = (r / iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize;
		int jMax = j + iSqrtSize;
		int iCnt = 0;
		
		for (; j < jMax; j++) {
			for(i = (r % iSqrtSize) * iSqrtSize; i < iMax; i++) {
				System.out.println("J: " + j + "  " + "I: " + i );
				
				reg[iCnt++] = super.getLatinSquare()[j][i];
			}
		}
		return reg;
	}
	protected int[] getRegion(int Col, int Row)
	{
		int[] region = {0};
		if((Col==0 || Col==1 || Col==2) && (Row==0 || Row==1 || Row==2)) {
			region = getRegion(0);
		}
		if((Col==3 || Col==4 || Col==5) && (Row==0 || Row==1 || Row==2)) {
			region = getRegion(1);
		}
		if((Col==6 || Col==7 || Col==8) && (Row==0 || Row==1 || Row==2)) {
			region = getRegion(2);
		}
		if((Col==0 || Col==1 || Col==2) && (Row==3 || Row==4 || Row==5)) {
			region = getRegion(3);
		}
		if((Col==3 || Col==4 || Col==5) && (Row==3 || Row==4 || Row==5)) {
			region = getRegion(4);
		}
		if((Col==6 || Col==7 || Col==8) && (Row==3 || Row==4 || Row==5)) {
			region = getRegion(5);
		}
		if((Col==0 || Col==1 || Col==2) && (Row==6 || Row==7 || Row==8)) {
			region = getRegion(6);
		}
		if((Col==3 || Col==4 || Col==5) && (Row==6 || Row==7 || Row==8)) {
			region = getRegion(7);
		}
		if((Col==7 || Col==8 || Col==9) && (Row==6 || Row==7 || Row==8)) {
			region = getRegion(8);
		}
		return region;
	}
	protected boolean isPartialSudoku()
	{
		for(int i = 0; i < 9; i++) {
			if(hasDuplicates(getRegion(i)) == false) {
				for(int j = 0; j < 9; j++) {
					if(hasAllValues(getRow(0), getRegion(j))) {
						return true;
					}
				}
			}
		}
		return false;
	}
		protected boolean isSudoku()
	{
		if(ContainsZero() == false) {
			if(isPartialSudoku() == true) {
				for(int i=0; i<9; i++) {
					hasAllValues(getRow(i),getColumn(i));
				
				}
			}
		}
		return false;
	}
		protected boolean isValueValid(int iValue, int Col, int Row)
	{
		int[] thisRow = getRow(Row);
		int[] thisCol = getColumn(Col);
		if(doesElementExist(thisCol, iValue) && doesElementExist(thisRow, iValue)) {
			return false;
		}
		else {
			return true;
		}
	}
}

