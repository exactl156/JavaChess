package chess5;

import java.util.Hashtable;

public class Pawn extends Piece {

	public boolean moved2;
	public Pawn(String position, boolean side, Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(position, side, board);
		type=1;
		hasMoved=false;
		// TODO Auto-generated constructor stub
	}

	public Pawn(char col, char row, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(col, row, side,board);
		type=1;
		hasMoved=false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMove(String positio) {
		// TODO Auto-generated method stub
		super.validateMove( positio);
		int row = (int)positio.charAt(1);
		int col = (int)positio.charAt(0);
		//System.out.println("ror"+row);
		int Prow= (int)PiecePosition.charAt(1);
		int Pcol= (int)PiecePosition.charAt(0);
		if(!hasMoved) 
		{
			if(col==Pcol&&(Prow-row)==2&&isBlack) 
			{
				hasMoved=false;
				moved2=true;
				return true;
			}
			if(col==Pcol&&(row-Prow)==2&&!isBlack) 
			{
				hasMoved=false;
				moved2=true;
				return true;
			}
		}
		
		
		if((Prow-row)==1&&col==Pcol&&isBlack) 
		{
			if(getPiece(positio).type==0) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		if((row-Prow)==1&&col==Pcol&&!isBlack) 
		{
			if(getPiece(positio).type==0) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		
		
		
		if((Prow-row)==1&&(Math.abs(col-Pcol))==1&&isBlack) 
		{
			if( getPiece(positio).type!=0&& ( !(getPiece(positio).isBlack&&isBlack) ) ) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		if((row-Prow)==1&&(Math.abs(col-Pcol))==1&&!isBlack) 
		{
			if( getPiece(positio).type!=0&& ( !(getPiece(positio).isBlack&&isBlack) ) ) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		return false;
	}

}
