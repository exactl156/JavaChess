package chess5;

import java.util.Hashtable;

public class Knight extends Piece 
{

	public Knight(String position, boolean side, Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(position, side,board);
		type=2;
		// TODO Auto-generated constructor stub
	}

	public Knight(char col, char row, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(col, row, side,board);
		type=2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMove(String positio) {
		// TODO Auto-generated method stub
		super.validateMove(positio);
		char chRow=positio.charAt(1);
		char chCol=positio.charAt(0);
		int row = (int)chRow;
		int col = (int)chCol;
		System.out.println("ror"+row);


		char chProw= PiecePosition.charAt(1);
		char chPcol= PiecePosition.charAt(0);
		int Prow= (int)chProw;
		int Pcol= (int)chPcol;

		if(Math.abs(Prow-row)*Math.abs(Pcol-col)!=2) 
		{
			return false;
		}
		
		if(getPiece(positio).type!=0&&(getPiece(positio).isBlack==isBlack))
		{
			return false;
		}
		return true;
	}

}
