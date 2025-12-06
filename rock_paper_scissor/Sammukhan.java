import java.util.Scanner;

public class Sammukhan{
    public String choice_niyati;
    public String choice_jeev;
    public final String akashvani = "Choose among:\nStone, Paper or Scissor";
    public final String border = "******************************************************";
    public final String cleaner = "\033[F";
    public final String newline = "\n";
    
    public Sammukhan(){
        /* Instantiate obj */
        
        // Get Niyati's choice
        double r = Math.random();
        
        this.choice_niyati = choice_niyati;
        this.choice_jeev=choice_jeev;
        
        if(r < 0.33){
            choice_niyati = "Stone";
        }
        else if(r < 0.66){
            choice_niyati = "Paper";
        }
        else{
            choice_niyati = "Scissor";
        }
        System.out.println(this.border+this.newline+this.border+this.newline);
        // Get Jeev's choice
        boolean valid = false;
        while (! valid){
            System.out.println(this.akashvani);
            Scanner scannerObj = new Scanner(System.in);
            choice_jeev = scannerObj.nextLine();
            //case deals
            choice_jeev = choice_jeev.substring(0,1).toUpperCase() + choice_jeev.substring(1).toLowerCase();
            // validate choice
            if (choice_jeev.equals("Stone") || choice_jeev.equals("Paper") || choice_jeev.equals("Scissor")){
                valid = true;
                this.choice_niyati = choice_niyati;
            }
            else{
                System.out.println("Invalid choice. " + this.akashvani);
            }
        }
        System.out.println(this.border+this.newline);
        this.choice_jeev = choice_jeev;
        
    }
    
    public void falitam(){
        // Compare choices
        System.out.println("Niyati chose: "+ this.choice_niyati);
        System.out.println("Jeev tried: "+ this.choice_jeev);
        if (this.choice_niyati.equals(this.choice_jeev)){
            System.out.println("Tie");
        }
        else if(this.choice_niyati.equals("Stone")){
            if (this.choice_jeev.equals("Paper")){
                System.out.println("Jeev succeeds");
            }
            else{
                System.out.println("Jeev failed");   
            }
        }
        else if(this.choice_niyati.equals("Paper")){
            if (this.choice_jeev.equals("Stone")){
                System.out.println("Jeev failed");
            }
            else{
                System.out.println("Jeev succeeds");
            }
        }
        else{
            if (this.choice_jeev.equals("Stone")){
                System.out.println("Jeev succeeds");
            }
            else{
                System.out.println("Jeev failed");
            }
        }
        System.out.println(this.border+this.newline+this.border+this.newline);
    
    }

}
