package chess5;

import java.util.Hashtable;

public class Bishop extends Piece {

	public Bishop(String position, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) 
	{
		super(position, side,board);
		type=3;
		// TODO Auto-generated constructor stub
	}

	public Bishop(char col, char row, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) 
	{
		super(col, row, side,board);
		type=3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMove(String positio) 
	{
		// TODO Auto-generated method stub
		super.validateMove(positio);
		
		char chRow=positio.charAt(1);
		char chCol=positio.charAt(0);
		int row = (int)chRow;
		int col = (int)chCol;
	//	System.out.println("ror"+row);


		char chProw= PiecePosition.charAt(1);
		char chPcol= PiecePosition.charAt(0);
		int Prow= (int)chProw;
		int Pcol= (int)chPcol;
		
		if(Math.abs(Pcol-col)!=Math.abs(Prow-row)) 
		{
			return false;
		}
		
		int gainRow=(chRow-chProw)/Math.abs((chRow-chProw));
		int gainCol=(chCol-chPcol)/Math.abs((chCol-chPcol));
		
		int j = (chPcol+gainCol);
		
		//System.out.println("current pos"+i+" gain"+gainCol+" row"+chRow+" "+(i<chRow));
		for(int i= (chProw+gainRow);i!=chRow;i+=gainRow) 
		{
			if(getPiece((char)i, (char)j).type!=0) 
			{
				return false;
			}
			j+=gainCol;
		}
		
		
		if(getPiece(positio).type!=0&&(getPiece(positio).isBlack==isBlack)) 
		{
			return false;
		}
		
		
		return true;
	}

}
