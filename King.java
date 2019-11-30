package chess5;
import java.util.Hashtable;

public class King extends Piece 
{

	public King(String position, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) 
	{
		super(position, side,board);
		type=4;
		// TODO Auto-generated constructor stub
	}

	public King(char col, char row, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) 
	{
		super(col, row, side,board);
		type=4;
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
		
		int gainRow=chRow-chProw;
		int gainCol=chCol-chPcol;
		
		if(Math.sqrt(gainRow*gainRow+gainCol*gainCol)>1.5) 
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
