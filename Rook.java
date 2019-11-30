package chess5;

import java.util.Hashtable;

public class Rook extends Piece 
{

	public Rook(String position, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(position, side,board);
		type=5;
		// TODO Auto-generated constructor stub
	}

	public Rook(char col, char row, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(col, row, side,board);
		type=5;
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
		System.out.println("ror"+row);


		char chProw= PiecePosition.charAt(1);
		char chPcol= PiecePosition.charAt(0);
		int Prow= (int)chProw;
		int Pcol= (int)chPcol;




		if(Prow!=row&&Pcol!=col) 
		{
			return false;
		}

		
		if(Prow==row) 
		{

			int diffC=(col-Pcol)/Math.abs(col-Pcol);
			for(char i=(char) (chPcol+diffC);i!=chCol;i+=diffC) 
			{
				if(getPiece(chRow, i).type!=0)
				{
					return false;
				}
			}
		}
		else 
		{
			int diffR=(row-Prow)/Math.abs((row-Prow));
			for(char i=(char) (chProw+diffR);i!=chRow;i+=diffR) 
			{
				if(getPiece(i, chPcol).type!=0)
				{
					return false;
				}
			}
		}
		
		
		if(getPiece(positio).type!=0&&(getPiece(positio).isBlack==isBlack))
		{
			return false;
		}
		return true;
	}

}
