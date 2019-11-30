package chess5;

import java.util.Hashtable;

public class Piece 
{
	public	String PiecePosition;
	public	boolean isBlack;
	public	int type;
	public Hashtable<Character, Hashtable<Character, Piece>> Pieceboard; 
	public Hashtable<String, Pawn> pawns;
	public Hashtable<String, Rook> rooks;
	public Hashtable<String, Bishop> bishops;
	public Hashtable<String, Knight> knights;
	public Hashtable<String, Queen> queens;
	public Hashtable<String, King> kings;
	//public boolean pinned;
	public Piece(String position,boolean side, Hashtable<Character, Hashtable<Character, Piece>> board) 
	{
		//pinned=false;
		Pieceboard=board;
		PiecePosition=position;
		isBlack=side;
		type=0;
	}
	public Piece(char col,char row,boolean side,Hashtable<Character, Hashtable<Character, Piece>> board) 
	{
		//pinned=false;
		Pieceboard=board;
		PiecePosition=""+col+row;
		isBlack=side;
		type=0;
	}
	public void setSide(boolean NewSide) 
	{
		isBlack=NewSide;
		if(isBlack) 
		{
			type=-1*Math.abs(type);
		}
		else 
		{
			type=Math.abs(type);
		}
	}
	@Override
	public String toString() {
		return ""+PiecePosition;
	}
	public void setPiecePosition(String piecePosition) 
	{
		PiecePosition = piecePosition;
	}
	public void setPiecePosition(char row,char col) 
	{
		PiecePosition = ""+col+row;
	}
	public boolean validateMove(String positio) 
	{
		char row=positio.charAt(1);
		char col=positio.charAt(0);
		return false;
	}
	public Piece getPiece(String Position) 
	{
		return Pieceboard.get(Position.charAt(1)).get(Position.charAt(0));
	}
	public Piece getPiece(char row, char col) 
	{
		return Pieceboard.get(row).get(col);
	}
	public void printBoard() 
	{
		System.out.println("board in "+type);
		for(char row='8';row>='1';row--) 
		{
			for(char col='a';col<='h';col++) 
			{
				System.out.printf("%5s", Pieceboard.get(row).get(col).type);
			}
			System.out.println();
			System.out.println();
		}
	}
}
