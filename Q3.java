import java.util.*;       

public class Q3{
    static String[][] boardGame = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    static int count = 0;
    static String player = "x";
    //static int pos;
    static int row;
    static int column;

    public static void main(String[] args){  
        play(); 
        
       
    } /// void main


    public static void play(){
        
        while(count < 9) {
            System.out.print(System.lineSeparator());
            System.out.println( "-- Tic Tac Toe Game --");
            printBoard();

            Scanner input = new Scanner(System.in);    
            System.out.println("It's your turn , Please select from 1 - 9."  );  
            System.out.print("Enter your input: ");
            //int pos = input.nextInt(); 

            try{
                row = input.nextInt();
                column = input.nexInt();           //จะเป็นตรวจสอบ Exception ที่สามารถเกิดขึ้น คือผู้เล่น ใส่ ตัวที่ไม่ใช่ 1-9
                if(!(row >= 0 && row <=9)){
                    continue;
                }
                if(!(column >= 0 && column <=9)){
                    continue;
                }
            }
            catch(Exception e) {
                System.out.println("Answer was wrong , Please Play Game Again Byeee"); // จะให้การทำงานหยุดแล้วผู้เล่น เล่นเกมใหม่ 
                break;
            }
            
           
            if(boardGame[row][column] == "x" || boardGame[row][column] == "o"){  //ถ้าเคยใส่ตำแหน่งๆนี้ไปแล้ว 
                System.out.println("Enter Again");    //ใส่ซ้ำอีกครั้ง
                pos = input.nextInt();                 
            }else{
                boardGame[row][column] = player;        //เก็บ x หรือ o ใส่ในboardGame   
                
                if (check_win(pos) ) {            //ถ้ามีคนชนะ 
                    System.out.println("End Game");      //จบเกม
                    break;                      //break
                }
                else {             
                    count ++;   //ไม่มีผู้ชนะ count บวกเพิ่ม 
                    if(player == "x"){   ///เปลี่ยน turn x เป็น turn o
                        player = "o";
                        }
                    else {
                        player = "x";
                    }
                }
            } ///if boardGame[pos] == "x" 
           
        }// while 
    }  //playGame
    public static void printBoard(){ ///ฟังก์ชัน printBpardเอาไว้ วาด BorlGame
        
        System.out.println("|" + boardGame[0][0] + "|" + boardGame[0][1] + "|" +boardGame[0][2] + "|");  
        System.out.println("-------");
        System.out.println("|" + boardGame[1][0]+ "|" + boardGame[1][1] + "|" +boardGame[1][2] + "|");
        System.out.println("-------");
        System.out.println("|" + boardGame[2][0] + "|" + boardGame[2][1] + "|" +boardGame[2][2] + "|");
        System.out.print(System.lineSeparator());   //ขึ้นบรรทัดใหม่ ให้บอร์ดดูง่ายขึ้นน 
    }  ///printborad

    public static boolean check_win(int pos) {          ////ฟังก์ชัน การ เช็คผู้ชนะ รีเทินค่าเป็น บูลีน  รับอากิวเม้นเป็น int pos
        String[] checkPosition = new String[4];         ///จองอาเรย์ไว้4ตัว 
        boolean contain = false;                        ///ยังไม่มีคนไหนชนะเลย 

        switch(pos) {
            case 1: 
                checkPosition = new String[] {      //เอาตัวเลขที่มีทุกตัว ทุกเคสมาเชค เช่น ผู้เล่นใส่1ในตำแหน่งที่1มีกี่เคสที่จะชนะ 
                    (boardGame[2][0] + boardGame[2][1] + boardGame[2][2]),  //ดึงค่าของบอร์ดมา เช็ค ในแต่ละตำแหน่ง
                    (boardGame[0][0] + boardGame[1][0] + boardGame[2][0]),
                    (boardGame[0][2] + boardGame[1][1] + boardGame[2][0])
                };
                break;

            case 2:
                checkPosition = new String[] {
                    (boardGame[0][1] + boardGame[1][1] + boardGame[2][1]), 
                    (boardGame[2][0] + boardGame[2][1]+ boardGame[2][2]),
                };
                break;

           case 3:
                checkPosition = new String[] {
                    (boardGame[2][0] + boardGame[2][1] + boardGame[2][2]), 
                    (boardGame[0][0] + boardGame[1][1] + boardGame[2][2]),
                    (boardGame[0][2] + boardGame[1][2] + boardGame[2][2])
                };
                break;

            case 4:
                checkPosition = new String[] {
                    (boardGame[1][0] + boardGame[1][1] + boardGame[1][2]), 
                    (boardGame[0][0]+ boardGame[1][0]+ boardGame[2][0]),
                };
                break;
                
            case 5:
                checkPosition = new String[] {
                    (boardGame[1][0] + boardGame[1][1] + boardGame[1][2]), 
                    (boardGame[0][0]+ boardGame[1][1] + boardGame[2][2]),
                    (boardGame[0][2]+ boardGame[1][1] + boardGame[2][0]),
                    (boardGame[0][1] + boardGame[1][1] + boardGame[2][1])
                };
                break;

            case 6:
                checkPosition = new String[] {
                    (boardGame[1][0] + boardGame[1][1] + boardGame[1][2]), 
                    (boardGame[0][2] + boardGame[1][2] + boardGame[2][2]),
                };
                break;

            case 7:
                checkPosition = new String[] {
                    (boardGame[0][0] + boardGame[1][1] + boardGame[2][2]), 
                    (boardGame[0][0] + boardGame[1][0] + boardGame[2][0]),
                    (boardGame[0][0]+ boardGame[0][1] + boardGame[0][2])
                };
                break;

            case 8:
                checkPosition = new String[] {
                    (boardGame[0][0] + boardGame[0][1] + boardGame[0][2]), 
                    (boardGame[0][1] + boardGame[1][1] + boardGame[2][1]),
                };
                break;

            case 9:
                checkPosition = new String[] {
                    (boardGame[0][0] + boardGame[0][1] + boardGame[0][2]), 
                    (boardGame[0][2] + boardGame[1][1] + boardGame[2][0]),
                    (boardGame[0][2]+ boardGame[1][2] + boardGame[2][2])
                };
                break;

           
        }

        contain = Arrays.asList(checkPosition).contains("xxx") || Arrays.asList(checkPosition).contains("ooo") ? true : false; 
          //เช็คเงื่อนไข ว่า checkPosition เท่ากับ xxx,ooo ไหม ถ้าใช่ให้ รีเทินtrue 
        if(contain && boardGame[pos][pos] == "x") {       /// contain เก็บเป็นtrue falseเอามาเช็คว่าตำแหน่งที่เอามาเป็น x ,o
            printBoard();
            System.out.println("X Win");
            return true; 
        }
        else if(contain && boardGame[pos][pos] == "o") {
            printBoard();
            System.out.println("O win");
            return true;
        }
        else {
            return false;
        } //else if

    } //check_win

}  ///class XO_Textmode
