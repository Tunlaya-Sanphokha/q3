import java.util.*;       

public class XO_Textmode {
    static String[] boardGame = {"0","1","2","3","4","5","6","7","8","9"};
    static int count = 0;
    static String player = "x";
    static int pos;


    public static void main(String[] args){  
        playGame(); 
        
       
    } /// void main


    public static void playGame(){
        
        while(count < 9) {
            System.out.print(System.lineSeparator());
            System.out.println( "-- Tic Tac Toe Game --");
            printBoard();

            Scanner input = new Scanner(System.in);    
            System.out.println("It's your turn , Please select from 1 - 9."  );  
            System.out.print("Enter your input: ");
            //int pos = input.nextInt(); 

            try{
                pos = input.nextInt();           //จะเป็นตรวจสอบ Exception ที่สามารถเกิดขึ้น คือผู้เล่น ใส่ ตัวที่ไม่ใช่ 1-9
                if(!(pos >= 0 && pos <=9)){
                    continue;
                }
            }
            catch(Exception e) {
                System.out.println("Answer was wrong , Please Play Game Again Byeee"); // จะให้การทำงานหยุดแล้วผู้เล่น เล่นเกมใหม่ 
                break;
            }
            
           
            if(boardGame[pos] == "x" || boardGame[pos] == "o"){  //ถ้าเคยใส่ตำแหน่งๆนี้ไปแล้ว 
                System.out.println("Enter Again");    //ใส่ซ้ำอีกครั้ง
                pos = input.nextInt();                 
            }else{
                boardGame[pos] = player;        //เก็บ x หรือ o ใส่ในboardGame   
                
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
        
        System.out.println("|" + boardGame[7] + "|" + boardGame[8] + "|" +boardGame[9] + "|");  
        System.out.println("-------");
        System.out.println("|" + boardGame[4] + "|" + boardGame[5] + "|" +boardGame[6] + "|");
        System.out.println("-------");
        System.out.println("|" + boardGame[1] + "|" + boardGame[2] + "|" +boardGame[3] + "|");
        System.out.print(System.lineSeparator());   //ขึ้นบรรทัดใหม่ ให้บอร์ดดูง่ายขึ้นน 
    }  ///printborad

    public static boolean check_win(int pos) {          ////ฟังก์ชัน การ เช็คผู้ชนะ รีเทินค่าเป็น บูลีน  รับอากิวเม้นเป็น int pos
        String[] checkPosition = new String[4];         ///จองอาเรย์ไว้4ตัว 
        boolean contain = false;                        ///ยังไม่มีคนไหนชนะเลย 

        switch(pos) {
            case 1: 
                checkPosition = new String[] {      //เอาตัวเลขที่มีทุกตัว ทุกเคสมาเชค เช่น ผู้เล่นใส่1ในตำแหน่งที่1มีกี่เคสที่จะชนะ 
                    (boardGame[1] + boardGame[2] + boardGame[3]),  //ดึงค่าของบอร์ดมา เช็ค ในแต่ละตำแหน่ง
                    (boardGame[7] + boardGame[4] + boardGame[1]),
                    (boardGame[9] + boardGame[5] + boardGame[1])
                };
                break;

            case 2:
                checkPosition = new String[] {
                    (boardGame[1] + boardGame[2] + boardGame[3]), 
                    (boardGame[8] + boardGame[5] + boardGame[2]),
                };
                break;

           case 3:
                checkPosition = new String[] {
                    (boardGame[1] + boardGame[2] + boardGame[3]), 
                    (boardGame[7] + boardGame[5] + boardGame[3]),
                    (boardGame[9] + boardGame[6] + boardGame[3])
                };
                break;

            case 4:
                checkPosition = new String[] {
                    (boardGame[4] + boardGame[5] + boardGame[6]), 
                    (boardGame[7] + boardGame[4] + boardGame[1]),
                };
                break;
                
            case 5:
                checkPosition = new String[] {
                    (boardGame[4] + boardGame[5] + boardGame[6]), 
                    (boardGame[7] + boardGame[5] + boardGame[3]),
                    (boardGame[8] + boardGame[5] + boardGame[2]),
                    (boardGame[9] + boardGame[5] + boardGame[1])
                };
                break;

            case 6:
                checkPosition = new String[] {
                    (boardGame[4] + boardGame[5] + boardGame[6]), 
                    (boardGame[9] + boardGame[6] + boardGame[3]),
                };
                break;

            case 7:
                checkPosition = new String[] {
                    (boardGame[7] + boardGame[8] + boardGame[9]), 
                    (boardGame[7] + boardGame[5] + boardGame[3]),
                    (boardGame[7] + boardGame[4] + boardGame[1])
                };
                break;

            case 8:
                checkPosition = new String[] {
                    (boardGame[7] + boardGame[8] + boardGame[9]), 
                    (boardGame[8] + boardGame[5] + boardGame[2]),
                };
                break;

            case 9:
                checkPosition = new String[] {
                    (boardGame[7] + boardGame[8] + boardGame[9]), 
                    (boardGame[9] + boardGame[6] + boardGame[3]),
                    (boardGame[9] + boardGame[5] + boardGame[1])
                };
                break;

           
        }

        contain = Arrays.asList(checkPosition).contains("xxx") || Arrays.asList(checkPosition).contains("ooo") ? true : false; 
          //เช็คเงื่อนไข ว่า checkPosition เท่ากับ xxx,ooo ไหม ถ้าใช่ให้ รีเทินtrue 
        if(contain && boardGame[pos] == "x") {       /// contain เก็บเป็นtrue falseเอามาเช็คว่าตำแหน่งที่เอามาเป็น x ,o
            printBoard();
            System.out.println("X Win");
            return true; 
        }
        else if(contain && boardGame[pos] == "o") {
            printBoard();
            System.out.println("O win");
            return true;
        }
        else {
            return false;
        } //else if

    } //check_win

}  ///class XO_Textmode
