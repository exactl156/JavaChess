package chess5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;



public class board {
	public Hashtable<Character, Hashtable<Character, Piece>> board;
	public Hashtable<Character, Piece> columns;
	public Hashtable<String, Pawn> pawns;
	public Hashtable<String, Rook> rooks;
	public Hashtable<String, Bishop> bishops;
	public Hashtable<String, Knight> knights;
	public Hashtable<String, Queen> queens;
	public Hashtable<String, King> kings;
	public Piece previousPiece;
	public Piece previousCapturedPiece;
	public String previosPosition;
	public King KingInCheck;
	public Piece intialize;
	public double turn;
	public boolean Whiteside;
	public boolean enPassantPossible;
	public String enPassantSquare;
	public Piece enPassantPawnLoc;
	public board() throws IOException 
	{
		System.out.println("in board");
		System.out.println("Board 4");
		intializeBoard();
		// TODO Auto-generated constructor stub
		//printBoard();
		generateTables();
		turn = 1;
		Whiteside=true;
		//testMoves();
		//ValidatetestMoves();
		//printBoard();
		/*System.out.println("knig"+knights.toString());
		System.out.println("paw"+pawns.toString());
		System.out.println("Que"+queens.toString());
		System.out.println("bi "+bishops.toString());*/
		printBoard();
		
		resetMoves();
		testEnpassant();
		//testCastleMoves();
		//testCheckMoves2();
		//System.out.println("bi "+bishops.toString());
		//testInputMoves();
		//		System.out.println(knights.toString());
		//		System.out.println(""+getPiece('1', 'a').type+getPiece('1', 'a').PiecePosition);
	}


	/*
	 * 1. this method resets the board to the intial layout.
	 * 2. it does so by intializing new peices.
	 * 3. It returns nothing but returns board to original state.
	 * */
	public void resetMoves() 
	{
		intializeBoard();
		//printBoard();
	}

	/*
	 * 1. this part tests the move function of the board
	 * 2. it does so with a string of moves to see if the board updates
	 * 3. it returns nothing but upadates the board.
	 * */
	public void testMoves() 
	{
		move(getPiece("b1"), "a3");
		move(getPiece("b8"), "a6");

		move(getPiece("b2"), "b3");
		move(getPiece("b7"), "b6");

		move(getPiece("c1"), "a3");
		move(getPiece("c8"), "a6");
	}
	/*
	 * */
public void testEnpassant() 
{
	ValidateMove(getPiece("e2"), "e4");
	printBoard();
	ValidateMove(getPiece("e4"), "e5");
	printBoard();
	ValidateMove(getPiece("d7"), "d5");
	printBoard();
	ValidateMove(getPiece("e5"), "d6");
	printBoard();
}

	/*
	 * 1. this method is devoted to testing validate moves
	 * 2. it does so by creating a string of moves to see if the board works with it.
	 * 3. it returns nothing but updates the board.
	 * */
	public void ValidatetestMoves() 
	{
		ValidateMove(getPiece("b1"), "a3");
		ValidateMove(getPiece("b8"), "a6");
		//printBoard();
		ValidateMove(getPiece("b2"), "b3");
		ValidateMove(getPiece("b7"), "b6");
		//printBoard();
		ValidateMove(getPiece("c1"), "a3");
		ValidateMove(getPiece("c8"), "a6");

		ValidateMove(getPiece("a2"), "a3");
		ValidateMove(getPiece("g7"), "g3");

		ValidateMove(getPiece("g2"), "g3");
		ValidateMove(getPiece("d7"), "d5");

		ValidateMove(getPiece("a1"), "c1");
		ValidateMove(getPiece("a8"), "c8");

		ValidateMove(getPiece("c1"), "c2");
		ValidateMove(getPiece("c8"), "d8");

		ValidateMove(getPiece("c1"), "b1");
		ValidateMove(getPiece("c8"), "a8");

		ValidateMove(getPiece("a3"), "c2");
		ValidateMove(getPiece("g8"), "h6");

		ValidateMove(getPiece("d1"), "c2");
		ValidateMove(getPiece("d8"), "h8");

		ValidateMove(getPiece("e2"), "e4");
		ValidateMove(getPiece("d8"), "d6");

		ValidateMove(getPiece("d6"), "g3");
		ValidateMove(getPiece("h2"), "g3");

		ValidateMove(getPiece("c8"), "b7");
		ValidateMove(getPiece("c1"), "b2");

		ValidateMove(getPiece("e4"), "e5");
		ValidateMove(getPiece("e5"), "e6");
		ValidateMove(getPiece("e6"), "f7");
		ValidateMove(getPiece("h6"), "g8");
		ValidateMove(getPiece("f7"), "g8");
		//ValidateMove(getPiece("c1"), "b2");
	}

	
	/*
	 * 1. This method is devoted to testing the board for checks
	 * 2. it does so by checking various checks positions to see how it reacts.
	 * 3. This method returns nothing but updates the board
	 * */
	public void testCheckMoves() 
	{
		ValidateMove(getPiece("e2"), "e4");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("d7"), "d5");//black pawn d7 fo d5
		printBoard();

		ValidateMove(getPiece("f1"), "b5");//white bishop f1 to b5 checking
		printBoard();
		ValidateMove(getPiece("c7"), "c6");//black pawn c7 to c6
		printBoard();
//turn 3 printed
		ValidateMove(getPiece("b5"), "a6");//white bishop b5 to a6 
		printBoard();//turn 3.5
		ValidateMove(getPiece("f8"), "b4");//black bishop f8 to b4 checking but fails b/c pawn
		printBoard();//turn 3.5

		ValidateMove(getPiece("b5"), "a6");//white bishop b5 to a6 causes turn to switch
		printBoard();
		ValidateMove(getPiece("e7"), "e6");//black pawn e7 moves to e6
		printBoard();

		ValidateMove(getPiece("d2"), "d3");
		printBoard();
		ValidateMove(getPiece("f8"), "b4");
		printBoard();
		
		ValidateMove(getPiece("a2"), "a3");
		printBoard();
		ValidateMove(getPiece("c2"), "c3");
		printBoard();
		
		ValidateMove(getPiece("c3"), "b4");
		ValidateMove(getPiece("b4"), "b6");
		printBoard();
		//ValidateMove(getPiece("b4"), "e1");
		//printBoard();
	}
	
	
	/*
	 * 1. this method is devoted to testing castling
	 * 2. it does so by recreating various castling situations
	 * 3. it returns nothing but updates board
	 * */
	public void testCastleMoves() 
	{
		ValidateMove(getPiece("g1"), "f3");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("g2"), "g3");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("f1"), "g2");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("e1"), "h1");//white pawn e2 to e4
		printBoard();
		
		resetMoves();
		printBoard();
		ValidateMove(getPiece("b1"), "c3");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("b2"), "b3");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("e2"), "e3");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("c1"), "b2");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("d1"), "e2");
		printBoard();
		ValidateMove(getPiece("e1"), "a1");
		printBoard();
	}
	
	
	/*
	 * 1. This method is devoted to testing the board for checks
	 * 2. it does so by checking various checks positions to see how it reacts.
	 * 3. This method returns nothing but updates the board
	 * */
	public void testCheckMoves2() 
	{
		ValidateMove(getPiece("e2"), "e4");//white pawn e2 to e4
		printBoard();
		ValidateMove(getPiece("d7"), "d5");//black pawn d7 fo d5
		printBoard();

		ValidateMove(getPiece("f1"), "b5");//white bishop f1 to b5 checking
		printBoard();
		ValidateMove(getPiece("c7"), "c6");//black pawn c7 to c6
		printBoard();
//turn 3 printed
		ValidateMove(getPiece("b5"), "a6");//white bishop b5 to a6 
		printBoard();//turn 3.5
		ValidateMove(getPiece("f8"), "b4");//black bishop f8 to b4 checking but fails b/c pawn
		printBoard();//turn 3.5

		ValidateMove(getPiece("b5"), "a6");//white bishop b5 to a6 causes turn to switch
		printBoard();
		ValidateMove(getPiece("e7"), "e6");//black pawn e7 moves to e6
		printBoard();

		ValidateMove(getPiece("d2"), "d3");//white pawn d2 to d3
		printBoard();
		ValidateMove(getPiece("f8"), "b4");//black bishop f8 to b4 causes check on white
		printBoard();
		
		ValidateMove(getPiece("a2"), "a3");//white pawn a2 to a3 failing move as it is in check
		printBoard();
		ValidateMove(getPiece("c2"), "c3");//white pawn c2 to c3  working move as it blocks check
		printBoard();
		
		ValidateMove(getPiece("c3"), "b4");//white pawn c3 to b4 captures bishop
		ValidateMove(getPiece("b4"), "b6");//white pawn b4 to b6 fails as it is two spaces ahead
		printBoard();
		//ValidateMove(getPiece("b4"), "e1");
		//printBoard();
	}
	
	
	/*
	 * 1. This method is devoted to testing human entered input
	 * 2. it does so by calling the input method.
	 * 3. it returns nothing.
	 * */
	public void testInputMoves() throws IOException 
	{
		getInputMoves();
	}


	/*
	 * 1. The goal of this method is to intialize the board.
	 * 2. It does so by using for loops with various mathematical manipulations
	 * 3. It returns nothing but does intialize all the pieces but does not set the black pieces types
	 * */
	public void intializeBoard() 
	{
		board = new Hashtable<Character, Hashtable<Character,Piece>>();
		for(char row='1';row<='8';row++) 
		{
			columns = new Hashtable<Character, Piece>();
			for(char col='a';col<='h';col++) 
			{
				if(row=='2'||row=='7') 
				{
					intialize = new Pawn(col, row, false,board);
					columns.put(col, intialize);
				}
				else if((row=='1'||row=='8')&&(col=='a'||col=='h')) 
				{
					intialize = new Rook(col, row, false,board);
					columns.put(col, intialize);
				}
				else if((row=='1'||row=='8')&&(col=='b'||col=='g')) 
				{
					intialize = new Knight(col, row, false,board);
					columns.put(col, intialize);
				}
				else if((row=='1'||row=='8')&&(col=='c'||col=='f')) 
				{
					intialize = new Bishop(col, row, false,board);
					columns.put(col, intialize);				
				}
				else if((row=='1'||row=='8')&&(col=='d')) 
				{
					intialize = new Queen(col, row, false,board);
					columns.put(col, intialize);				
				}
				else if((row=='1'||row=='8')&&(col=='e')) 
				{
					intialize = new King(col, row, false,board);
					columns.put(col, intialize);				
				}
				else 
				{
					intialize = new Piece(col, row, false,board);
					columns.put(col, intialize);
				}
			}
			board.put(row, columns);
		}
		setBlack();
	}


	/*
	 * 1. This method is devoted to setting the top half of the board as black
	 * 2. it does so by using a double for loop to parse through the top half of the board
	 * and multiplying each type by -1.
	 * 3. The method returns nothing but changes the types of all blacks to negative mubers.
	 * */
	public void setBlack() 
	{
		for(char row='4';row<='8';row++) 
		{
			for(char col='a';col<='h';col++) 
			{
				board.get(row).get(col).setSide(true);
			}
		}
	}


	/*
	 * 1. The goal of this method is to provide access to the tables neccessery to find each piece
	 * 2. it does so by accessing the board hastable and adding the corresponding piece to the corresponding
	 * hastable.
	 * 3. it returns nothing but does generate the table for the pieces. Does not differentiate between black
	 * and white pieces*/
	public void generateTables() 
	{
		bishops=new Hashtable<String, Bishop>();
		bishops.put("f1", (Bishop)getPiece("f1"));
		bishops.put("c1", (Bishop)getPiece("c1"));
		bishops.put("f8", (Bishop)getPiece("f8"));
		bishops.put("c8", (Bishop)getPiece("c8"));
		//System.out.println(bishops.toString());
		queens=new Hashtable<String, Queen>();
		queens.put("d1", (Queen)getPiece("d1"));
		queens.put("d8", (Queen)getPiece("d8"));
		System.out.println(queens.toString());
		kings=new Hashtable<String, King>();
		kings.put("e1", (King)getPiece("e1"));
		kings.put("e8", (King)getPiece("e8"));
		//System.out.println(kings.toString());
		knights=new Hashtable<String, Knight>();
		knights.put("b1", (Knight)getPiece("b1"));
		knights.put("g1", (Knight)getPiece("g1"));
		knights.put("b8", (Knight)getPiece("b8"));
		knights.put("g8", (Knight)getPiece("g8"));
		//System.out.println(knights.toString());
		rooks=new Hashtable<String, Rook>();
		rooks.put("a1", (Rook)getPiece("a1"));
		rooks.put("h1", (Rook)getPiece("h1"));
		rooks.put("a8", (Rook)getPiece("a8"));
		rooks.put("h8", (Rook)getPiece("h8"));
		//System.out.println(rooks.toString());
		pawns = new Hashtable<String, Pawn>();

		pawns.put("a2", (Pawn)getPiece("a2"));
		pawns.put("b2", (Pawn)getPiece("b2"));
		pawns.put("c2", (Pawn)getPiece("c2"));
		pawns.put("d2", (Pawn)getPiece("d2"));
		pawns.put("e2", (Pawn)getPiece("e2"));
		pawns.put("f2", (Pawn)getPiece("f2"));
		pawns.put("g2", (Pawn)getPiece("g2"));
		pawns.put("h2", (Pawn)getPiece("h2"));


		pawns.put("a7", (Pawn)getPiece("a7"));
		pawns.put("b7", (Pawn)getPiece("b7"));
		pawns.put("c7", (Pawn)getPiece("c7"));
		pawns.put("d7", (Pawn)getPiece("d7"));
		pawns.put("e7", (Pawn)getPiece("e7"));
		pawns.put("f7", (Pawn)getPiece("f7"));
		pawns.put("g7", (Pawn)getPiece("g7"));
		pawns.put("h7", (Pawn)getPiece("h7"));

		//System.out.println(pawns.toString());
	}


	/*
	 * 1. the goal of this method is to print the board.
	 * 2. it does so with a double for loop the literally prints the type
	 * 3. It returns nothing but prints the board to the concil.
	 * */
	public void printBoard() 
	{
		System.out.println("The turn is "+turn+(Whiteside?"white":"black"));
		for(char row='8';row>='1';row--) {
			for(char col='a';col<='h';col++) 
			{
				System.out.printf("%5s", board.get(row).get(col).type);
			}
			System.out.println();
			System.out.println();
		}
	}


	/*
	 * 1. the purpose of undoMove is to move a piece from it moved position and put it back to the unmoved
	 * place
	 * 2. It does so by using the recording in the previous move method to reconstruct the state before th
	 * move occured.
	 * 3. It returns nothing but changes the state of the board to its previous position.
	 * */
	public void undoMove(Piece p, String previousPosition) 
	{
		//previousPiece=p.PiecePosition;
		Piece capturedPiece = getPiece(previousPosition);
		removePiecePosition(previousPosition, capturedPiece);

		Piece empty = new Piece(p.PiecePosition, false,board);
		setPiecePosition(p.PiecePosition, empty);

		setPiecePosition(previousPosition, p);
		p.PiecePosition=previousPosition;
		turn--;
		Whiteside=!Whiteside;
	}


	/*
	 * 1. the purpose of move is to take a piece and move it to anther swuare while recordings its old 
	 * location
	 * 2. It does so by first recordings its location and the location of anyother captured pieces
	 * It then creates an empty square to be place into the old swuare before moving its piece in the new square
	 * 3. this method returns nothing but updates the board and recordings.
	 * */
	public boolean move(Piece p,String position)
	{
		//System.out.println("knighs"+knights.toString());
		previousPiece=p;
		previosPosition=p.PiecePosition;
		Piece capturedPiece = getPiece(position);
		removePiecePosition(position, capturedPiece);

		Piece empty = new Piece(p.PiecePosition, false,board);
		setPiecePosition(p.PiecePosition, empty);

		setPiecePosition(position, p);
		p.PiecePosition=position;
		
		
		boolean temp = KingInCheck();
		//System.out.println("king check stat "+temp+" previous pos "+previosPosition);
		turn=0.5+turn;
		Whiteside=!Whiteside;
		if (temp) 
		{
			if(KingInCheck.isBlack==p.isBlack) 
			{
				undoMove(p, previosPosition);
				return false;
			}
			else 
			{
				return true;
			}
			/*if(KingInCheck.isBlack) 
			{
				System.out.println("the black king is in check");
			}
			else 
			{
				System.out.println("the white king is in check");
			}*/
		}
		if(Math.abs(p.type)==1) 
		{
			if(((Pawn)p).moved2) 
			{
				enPassantPossible=true;
				enPassantPawnLoc=p;
				if(p.isBlack) 
				{
					enPassantSquare=""+enPassantPawnLoc.PiecePosition.charAt(0)+(char)(enPassantPawnLoc.PiecePosition.charAt(1)+1);
				}
				else 
				{
					enPassantSquare=""+enPassantPawnLoc.PiecePosition.charAt(0)+(char)(enPassantPawnLoc.PiecePosition.charAt(1)-1);
				}
				((Pawn)p).moved2=false;
			}
			else 
			{
				enPassantPossible=false;
			}
		}
		else
		{
			enPassantPossible=false;
		}
		return true;
	}


	/*
	 * 1. the purpose of this method is to remove a piece at a specfic position
	 * 2. it does so by using a switch before removing it from the list of pieces of its type. It then
	 * records it in the previousCapturepiece
	 * 3.It returns nothing but records the captured piece
	 * */
	public void removePiecePosition(String position,Piece pi) 
	{
		switch (Math.abs(pi.type)) 
		{
		case 1:
			pawns.remove(position);
			break;
		case 2:
			knights.remove(position);
			break;
		case 3:
			bishops.remove(position);
			break;
		case 4:
			kings.remove(position);
			break;
		case 5:
			rooks.remove(position);
			break;
		case 10:
			queens.remove(position);
			break;
		default:
			break;
		}
		previousCapturedPiece=pi;
	}


	/*
	 * 1. the purpose of this method is to set the position of a piece on the board
	 * 2. does so by removing the piece off its type off list with a switch before addition the piece
	 * to the board. it then readds itself to the board.
	 * 3. t returns nothing but updates the board.
	 * */
	public void setPiecePosition(String Position, Piece pi) 
	{
		switch (Math.abs(pi.type)) 
		{		
		case 1:
			pawns.remove(pi.PiecePosition);
			pawns.put(Position,(Pawn)pi);
			break;
		case 2:
			knights.remove(pi.PiecePosition);
			knights.put(Position,(Knight)pi);
			break;
		case 3:
			bishops.remove(pi.PiecePosition);
			bishops.put(Position,(Bishop)pi);
			break;
		case 4:
			kings.remove(pi.PiecePosition);
			kings.put(Position,(King)pi);
			break;
		case 5:
			rooks.remove(pi.PiecePosition);
			rooks.put(Position,(Rook)pi);
			break;
		case 10:
			queens.remove(pi.PiecePosition);
			queens.put(Position,(Queen)pi);
			break;
		default:
			break;
		}
		board.get(Position.charAt(1)).put(Position.charAt(0), pi);
	}


	/*
	 * 1. this method is a short cut for getting a position from a string location
	 * 2. it uses two gets to get the value
	 * 3. it returns the piece in th position 
	 * */
	public Piece getPiece(String Position) 
	{
		return board.get(Position.charAt(1)).get(Position.charAt(0));
	}


	/*
	 * 1. this method is a short cut for getting a position from a string location
	 * 2. it uses two gets to get the value
	 * 3. it returns the piece in th position 
	 * */
	public Piece getPiece(char row, char col) 
	{
		return board.get(row).get(col);
	}


	/*
	 * 1. the purpose of this method is to validate the move and if validated move the peice.
	 * 2. it uses a switch and the validate move of the peiece to find if it is a valid move 
	 * 3. it returns nothing but does cupdate the board.
	 * */
	public void ValidateMove(Piece p, String position) 
	{
		if(!enpassantPass(p, position)) 
		{
		switch (Math.abs(p.type)) 
		{
		case 1:
			if(((Pawn)p).validateMove(position)) 
			{
				
				boolean r=move(p, position);
				if(r)p.hasMoved=true;
				if(position.charAt(1)=='8') 
				{
					PromotePawn(p);
				}
				
				System.out.println(enPassantPossible+" "+enPassantSquare+" "+enPassantPawnLoc.isBlack);
			}
			break;
		case 2:
			if(((Knight)p).validateMove(position)) 
			{
				boolean r=move(p, position);
				if(r)p.hasMoved=true;
			}
			break;
		case 3:
			if(((Bishop)p).validateMove(position)) 
			{
				boolean r=move(p, position);
				if(r)p.hasMoved=true;
			}
			break;
		case 4:
			if((position.charAt(0)=='a'||position.charAt(0)=='h')&&(position.charAt(1)=='1'||position.charAt(1)=='8') )
			{
				if(((King)p).validateCastle(position)) 
				{
					CastleMove(p, position);
				}
			}
			else 
			{
				if(((King)p).validateMove(position)) 
				{
					boolean r=move(p, position);
					if(r)p.hasMoved=true;
				}
			}
			break;
		case 5:
			if(((Rook)p).validateMove(position)) 
			{
				boolean r=move(p, position);
				if(r)p.hasMoved=true;
			}
			break;
		case 10:
			if(((Queen)p).validateMove(position)) 
			{
				boolean r=move(p, position);
				if(r)p.hasMoved=true;
			}
			break;
		default:
			break;
		}
		}
	}
	
	
	public void CastleMove(Piece p,String position) 
	{
		char t = position.charAt(0);
		if(t=='a') 
		{
			if(p.isBlack) 
			{
				move(p,"c8" );
				move(getPiece(position),"d8");
			}
			else 
			{
				move(p,"c1" );
				move(getPiece(position),"d1");
			}
		}
		else 
		{
			if(p.isBlack) 
			{
				move(p,"g8" );
				move(getPiece(position),"f8");
			}
			else 
			{
				move(p,"g1" );
				move(getPiece(position),"f1");
			}
		}
	}


	/*
	 * 1. the purpose of this method is to promote a piece.
	 * 2. it does so by removing the piece and subsituting another piece. It assumes the move has been validated
	 * 3. it returns nothing.
	 * */
	public void PromotePawn(Piece p) 
	{
		Queen q = new Queen(p.PiecePosition, p.isBlack, p.Pieceboard);
		//	System.out.println("quen pos"+q.PiecePosition);

		pawns.remove(p.PiecePosition);
		queens.put(p.PiecePosition, q);
		//	System.out.println(pawns);
		//	System.out.println(queens);
		board.get(p.PiecePosition.charAt(1)).put(p.PiecePosition.charAt(0), q);
		//	System.out.println(getPiece("g8").type);
	}
	
	public boolean enpassantPass(Piece p, String position) 
	{
		
		if(enPassantPossible) 
		{
			char PasRow=position.charAt(1);
			char PasCol=position.charAt(0);
			int iPasRow=(int)PasRow;
			int iPasCol=(int)PasCol;
			
			char Row=p.PiecePosition.charAt(1);
			char Col=p.PiecePosition.charAt(0);
			int iRow=(int)Row;
			int iCol=(int)Col;
			
			if(Math.abs(iRow-iPasRow)==1&&Math.abs(iPasCol-iCol)==1&&(enPassantPawnLoc.type==(-p.type))) 
			{
				move(p, enPassantSquare);
				removePiecePosition((enPassantPawnLoc.PiecePosition), (enPassantPawnLoc));
				return true;
			}
		}
		
		return false;
	}

	/*
	 * 1. This method obtains input from the user
	 * 2. it does so by using a bufferedreader and a tokenizer to get tokens from user till
	 * the end string is inputed
	 * 3. it returns nothing by recieves the moves.
	 * */
	public void getInputMoves() throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input;
		while (true) 
		{	
			input=br.readLine();
			if(input.equals("end"))break;
			st = new StringTokenizer(input);
			ValidateMove(getPiece(st.nextToken()), st.nextToken());
			printBoard();
		}

	}


	/*
	 * 1. this method is devoted to determine if the king is in check
	 * 2. it does so by parsing through and seeing if a king can be taken by a piece
	 * 3. If it can it returns true else it returns false.
	 * */
	public boolean KingInCheck() 
	{
		Enumeration<String> Kingkeys = kings.keys();
		while(Kingkeys.hasMoreElements())
		{
			String key = Kingkeys.nextElement();
			King Kin=kings.get(key);
			String key2 = Kingkeys.nextElement();
			King Kin2=kings.get(key2);
			if(bishopCheck(Kin) || rookCheck(Kin)||queenCheck(Kin)||pawnCheck(Kin)||knightCheck(Kin))
			{
				KingInCheck=Kin;
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * 1.This method is devoted to seeing if the bishop can check the king
	 * 2. it does so by seeing if the bishop can take the king position which is stored
	 * 3. It returns true or false whether Bishops can take the king
	 * */
	public boolean bishopCheck(Piece king) 
	{
		//printBoard();
		Enumeration<String> BihopKeys = bishops.keys();
		while(BihopKeys.hasMoreElements())
		{
			String key = BihopKeys.nextElement();
			Bishop bish=bishops.get(key);
			if(bish.validateMove(king.PiecePosition)) 
			{
				return true;
			}

		}
		return false;
	}
	
	
	/*
	 * 1.This method is devoted to seeing if the Rook can check the king
	 * 2. it does so by seeing if the Rook can take the king position which is stored
	 * 3. It returns true or false whether Rooks can take the king
	 * */
	public boolean rookCheck(Piece king) 
	{
		//printBoard();
		Enumeration<String> RookKeys = rooks.keys();
		while(RookKeys.hasMoreElements())
		{
			String key = RookKeys.nextElement();
			Rook roo=rooks.get(key);
			if(roo.validateMove(king.PiecePosition)) 
			{
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * 1.This method is devoted to seeing if the Queen can check the king
	 * 2. it does so by seeing if the Queen can take the king position which is stored
	 * 3. It returns true or false whether Queens can take the king
	 * */
	public boolean queenCheck(Piece king) 
	{
		//printBoard();
		Enumeration<String> queeKeys = queens.keys();
		while(queeKeys.hasMoreElements())
		{
			String key = queeKeys.nextElement();
			Queen qu=queens.get(key);
			if(qu.validateMove(king.PiecePosition)) 
			{
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * 1.This method is devoted to seeing if the Knight can check the king
	 * 2. it does so by seeing if the Knight can take the king position which is stored
	 * 3. It returns true or false whether Knights can take the king
	 * */
	public boolean knightCheck(Piece king) 
	{
		//printBoard();
		Enumeration<String> kniKeys = knights.keys();
		while(kniKeys.hasMoreElements())
		{
			String key = kniKeys.nextElement();
			Knight kn=knights.get(key);
			if(kn.validateMove(king.PiecePosition)) 
			{
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * 1.This method is devoted to seeing if the Pawn can check the king
	 * 2. it does so by seeing if the Pawn can take the king position which is stored
	 * 3. It returns true or false whether Pawns can take the king
	 * */
	public boolean pawnCheck(Piece king) 
	{
		//printBoard();
		Enumeration<String> pawKeys = pawns.keys();
		while(pawKeys.hasMoreElements())
		{
			String key = pawKeys.nextElement();
			Pawn paws=pawns.get(key);
			if(paws.validateMove(king.PiecePosition)) 
			{
				return true;
			}
		}
		return false;
	}

}
