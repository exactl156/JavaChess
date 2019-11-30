package chess5;

import java.util.Hashtable;

public class Queen extends Piece {

	public Queen(String position, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(position, side,board);
		type=10;
		// TODO Auto-generated constructor stub
	}

	public Queen(char col, char row, boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) {
		super(col, row, side,board);
		type=10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateMove(String positio) 
	{
		// TODO Auto-generated method stub
		super.validateMove(positio);
		
		Bishop DummyBish = new Bishop(PiecePosition, isBlack, Pieceboard);
		Rook DummyRook = new Rook(PiecePosition, isBlack, Pieceboard);
		
		
		if(DummyBish.validateMove(positio)||DummyRook.validateMove(positio)) 
		{
			return true;
		}
		
		
		return false;
	}

}
