package sgrh;
import java.io.*;
public class Menu {
    private byte op;
    private Opr opr;
    private  Validacoes v;
    private Consulta cs;
    public Menu(){
    v=new Validacoes();
    cs=new Consulta();
   //
    //opr
    }   
    public void menuPrincipal(){
         int op;
        Tarefas t=new Tarefas();;
         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Bem Vindo <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        do{
        System.out.println("============================== Menu Principal ================================");
        System.out.println("==============================================================================");
        System.out.println(" 1 - Cadastrar funcionarios \n 2 - Relatorio da Empresa \n 3 - Operações \n 0 - Sair");
        System.out.println("==============================================================================");
            op=v.validarInt("a opcao",0,3);
            switch(op){
                case 1: 
                    t.cadastro();
                    t.escreverFicheiroTXT("funcionarios.txt");
                    t.escreverFicheiroDAT("funcionarios.dat");
                    break;
                case 2:
                    menuConsultas();
                break;
                case 3:
                    menuOP();
                    break;
                    default: 
                    System.out.println("Obrigado por usar nosso aplicativo!");
                    break;
            }
        }while(op!=0);   
    }
    public void menuOP() {
        opr= new Opr();
         opr.lerFich("funcionarios.txt");
        //try{
           do{
           System.out.println("============================= Menu Operações =================================");
           System.out.println("==============================================================================");
           System.out.println(" 1 - Lista de Funcionarios funcionarios \n 2 - Remover Funcionarios da Empresa \n 3 - Actualizar Dados \n 0 - Voltar");
           System.out.println("==============================================================================");
           op=v.validarByte("a opcao",0,3);
            switch(op){
                case 1: 
                    //opr.ordenarNome();
                    //opr.escreverFicheiroTXT("funcionarios.txt");
                    break;
                case 2:
                   opr.Remover();
                   opr.escreverFicheiroDAT("funcionarios.dat");
                    break;
                case 3:
                   opr.menuActualizacao();
                break;
                default: 
                    System.out.println("Obrigado por usar nosso aplicativo!");
                break;
                   
            }
            opr.escreverFicheiroTXT("Funcionarios.txt");
        }while(op!=0);
        //}catch(IOException | ClassNotFoundException ios){ios.getMessage();}
    }
    public void menuConsultas() {
    int op; float q;
    try{
        do{
            System.out.println("========================== Menu De Relatorios  ===============================");
            System.out.println("==============================================================================");
            System.out.println("1 - Numero de funcionarios Masculinos \n2 - Numero de Funcionarios Femininos \n3 - Total de Funcionarios \n4 - Total Salarios Funcionarios \n0 - Voltar");
            System.out.println("==============================================================================");
            op=v.validarInt("a opcao",0,4);
           
            
            switch(op){
                case 1: 
                    System.out.println("==============================================================================");
                    System.out.println(" | Codigo ||      BI         ||   Contacto  || Nome Completo");
                    System.out.println(" |--------||-----------------||------------ || ----------------");
                    cs.Principal(1);
                    System.out.println("==============================================================================");
                break;
                
                case 2: 
                    System.out.println("==============================================================================");
                    System.out.println(" | Codigo ||      BI         ||   Contacto  || Nome Completo");
                    System.out.println(" |--------||-----------------||------------ || ----------------");
                    cs.Principal(2);
                    System.out.println("==============================================================================");
                break;
                
                case 3:
                   System.out.println("==============================================================================");
                    cs.Principal(3);
                    System.out.println("==============================================================================");
                break;
                case 4:
                    System.out.println("==============================================================================");
                   cs.Principal(4);
                    System.out.println("==============================================================================");
                break;
                
                default: 
                    System.out.println("============================= Fim das Consultas ==============================");
                
                break;
            }
        }while(op!=0);
        }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
          
    }
}