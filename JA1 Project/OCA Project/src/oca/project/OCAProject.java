package oca.project;

//import java.awt.Color;
import java.util.ArrayList;
//import java.util.Date;

/**
 * Main class that creates all employees and specifies their managers
 */
public class OCAProject {
    
//    static MainForm startForm = new MainForm();
//    static AssignBonusForm bonusForm = new AssignBonusForm();
//    static PersonalDataForm personalInfoForm = new PersonalDataForm();
//    static CreatePaymentsForm createPaymentsForm = new CreatePaymentsForm();
//    static ReportForm reportForm = new ReportForm();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Person> staffList = new ArrayList<>();
        
        
        //Creating the salaried employees
        CEO JamesMint = new CEO(); //Create the CEO position
        JamesMint.setFirstName("James");
        JamesMint.setLastName("Mint");
        JamesMint.setPosition("CEO");
        JamesMint.setDoB("28/12/1977");
        JamesMint.setPayPeriod(TimePeriod.MONTHLY);
        JamesMint.setStartDate("10/01/2010");
                
        //Create Bill Johns
        AdministrationManager BillJohns = new AdministrationManager(JamesMint);
        BillJohns.setFirstName("Bill");
        BillJohns.setLastName("Johns");
        BillJohns.setDoB("13/04/1981");
        BillJohns.setTimePeriod(TimePeriod.MONTHLY);
        BillJohns.setStartDate("10/05/2012");
        
        //Create Kate Hudson
        BranchManager KateHudson = new BranchManager(BillJohns);
        KateHudson.setFirstName("Kate");
        KateHudson.setLastName("Hudson");
        KateHudson.setDoB("13/07/1981");
        KateHudson.setTimePeriod(TimePeriod.MONTHLY);
        KateHudson.setStartDate("11/03/2013");
        
        //Create Scarlet Green
        BranchManager ScarletGreen = new BranchManager(BillJohns);
        ScarletGreen.setFirstName("Scarlet");
        ScarletGreen.setLastName("Green");
        ScarletGreen.setDoB("20/03/1980");
        ScarletGreen.setTimePeriod(TimePeriod.MONTHLY);
        ScarletGreen.setStartDate("10/05/2013");
               
        //Create Amanda Green
        BranchManager AmandaGreen = new BranchManager(BillJohns);
        AmandaGreen.setFirstName("Amanda");
        AmandaGreen.setLastName("Green");
        AmandaGreen.setDoB("05/04/1979");
        AmandaGreen.setTimePeriod(TimePeriod.MONTHLY);
        AmandaGreen.setStartDate("14/10/2014");
        
        //Create Eric White
        FinancialAdministrator EricWhite = new FinancialAdministrator(JamesMint);
        EricWhite.setFirstName("Eric");
        EricWhite.setLastName("White");
        EricWhite.setDoB("21/05/1984");
        EricWhite.setTimePeriod(TimePeriod.FORTNIGHTLY);
        EricWhite.setStartDate("10/04/2011");
        
        //Create Julia Smith
        HROfficer JuliaSmith = new HROfficer(JamesMint);
        JuliaSmith.setFirstName("Julia");
        JuliaSmith.setLastName("Smith");
        JuliaSmith.setDoB("17/02/1973");
        JuliaSmith.setTimePeriod(TimePeriod.MONTHLY);
        JuliaSmith.setStartDate("13/06/2010");
        
        //Creating Victoria Bell
        ProjectManager VictoriaBell = new ProjectManager(AmandaGreen);
        VictoriaBell.setFirstName("Victoria");
        VictoriaBell.setLastName("Bell");
        VictoriaBell.setDoB("11/01/1978");
        VictoriaBell.setTimePeriod(TimePeriod.FORTNIGHTLY);
        VictoriaBell.setStartDate("30/04/2014");
        
        //Creating Charlotte Hond
        ProjectManager CharlotteHond = new ProjectManager(KateHudson);
        CharlotteHond.setFirstName("Charlotte");
        CharlotteHond.setLastName("Hond");
        CharlotteHond.setDoB("01/07/1988");
        CharlotteHond.setTimePeriod(TimePeriod.FORTNIGHTLY);
        CharlotteHond.setStartDate("28/02/2012");
        
        //Creating Christine Bennet
        ProjectManager ChristineBennet = new ProjectManager(ScarletGreen);
        ChristineBennet.setFirstName("Christine");
        ChristineBennet.setLastName("Bennet");
        ChristineBennet.setDoB("16/06/1982");
        ChristineBennet.setTimePeriod(TimePeriod.FORTNIGHTLY);
        ChristineBennet.setStartDate("11/06/2011");
        
        //Creating John Norton
        SeniorProgramDeveloper JohnNorton = new SeniorProgramDeveloper(VictoriaBell);
        JohnNorton.setFirstName("John");
        JohnNorton.setLastName("Norton");
        JohnNorton.setDoB("17/07/1980");
        JohnNorton.setTimePeriod(TimePeriod.MONTHLY);
        JohnNorton.setStartDate("10/09/2010");
        
        //Creating Ashley Simpson (without lip-syncing)
        SeniorProgramDeveloper AshleySimpson = new SeniorProgramDeveloper(CharlotteHond);
        AshleySimpson.setFirstName("Ashley");
        AshleySimpson.setLastName("Simpson");
        AshleySimpson.setDoB("12/05/1984");
        AshleySimpson.setTimePeriod(TimePeriod.MONTHLY);
        AshleySimpson.setStartDate("15/06/2010");

        //Create Alex Dillon
        ProgramDeveloper AlexDillon = new ProgramDeveloper(JohnNorton);
        AlexDillon.setFirstName("Alex");
        AlexDillon.setLastName("Dillon");
        AlexDillon.setDoB("10/03/1989");
        AlexDillon.setTimePeriod(TimePeriod.FORTNIGHTLY);
        AlexDillon.setStartDate("14/09/2014");
        
        //Create Andrew Sampson
        ProgramDeveloper AndrewSampson = new ProgramDeveloper(AshleySimpson);
        AndrewSampson.setFirstName("Andrew");
        AndrewSampson.setLastName("Simpson");
        AndrewSampson.setDoB("09/04/1984");
        AndrewSampson.setTimePeriod(TimePeriod.FORTNIGHTLY);
        AndrewSampson.setStartDate("04/07/2010");
        
        //Create David Galloway
        ProgramDeveloper DavidGalloway = new ProgramDeveloper(ChristineBennet);
        DavidGalloway.setFirstName("David");
        DavidGalloway.setLastName("Galloway");
        DavidGalloway.setDoB("06/12/1981");
        DavidGalloway.setTimePeriod(TimePeriod.MONTHLY);
        DavidGalloway.setStartDate("05/11/2013");
        
        //Create Peter Gordon
        Receptionist PeterGordon = new Receptionist(JuliaSmith);
        PeterGordon.setFirstName("Peter");
        PeterGordon.setLastName("Gordon");
        PeterGordon.setDoB("30/09/1983");
        PeterGordon.setTimePeriod(TimePeriod.FORTNIGHTLY);
        PeterGordon.setStartDate("10/05/2010");
        
        //Create Michael Brown the Xmas baby
        SalesManager MichaelBrown = new SalesManager(JamesMint);
        MichaelBrown.setFirstName("Michael");
        MichaelBrown.setLastName("Brown");
        MichaelBrown.setDoB("25/12/1985");
        MichaelBrown.setTimePeriod(TimePeriod.FORTNIGHTLY);
        MichaelBrown.setStartDate("27/07/2012");
        
        //Create Andrew Black 
        SystemAdministrator AndrewBlack = new SystemAdministrator(AmandaGreen);
        AndrewBlack.setFirstName("Andrew");
        AndrewBlack.setLastName("Black");
        AndrewBlack.setDoB("15/04/1976");
        AndrewBlack.setTimePeriod(TimePeriod.MONTHLY);
        AndrewBlack.setStartDate("04/05/2012");
        
        //Create Joanne Dowman
        SystemAdministrator JoanneDowman = new SystemAdministrator(KateHudson);
        JoanneDowman.setFirstName("Joanne");
        JoanneDowman.setLastName("Dowman");
        JoanneDowman.setDoB("13/12/1980");
        JoanneDowman.setTimePeriod(TimePeriod.FORTNIGHTLY);
        JoanneDowman.setStartDate("07/07/2014");
        
        //Create Michael Perry
        SystemAdministrator MichaelPerry = new SystemAdministrator(ScarletGreen);
        MichaelPerry.setFirstName("Michael");
        MichaelPerry.setLastName("Perry");
        MichaelPerry.setDoB("12/11/1977");
        MichaelPerry.setTimePeriod(TimePeriod.FORTNIGHTLY);
        MichaelPerry.setStartDate("01/03/2014");
        
        //Create Andrew Blank... really... "Blank"?
        SystemAnalyst AndrewBlank = new SystemAnalyst(VictoriaBell);
        AndrewBlank.setFirstName("Andrew");
        AndrewBlank.setLastName("Blank");
        AndrewBlank.setDoB("15/09/1981");
        AndrewBlank.setTimePeriod(TimePeriod.MONTHLY);
        AndrewBlank.setStartDate("19/08/2014");
        
        //Create Carol White - maybe I should apply, lots of relatives there already 
        SystemAnalyst CarolWhite = new SystemAnalyst(CharlotteHond);
        CarolWhite.setFirstName("Carol");
        CarolWhite.setLastName("White");
        CarolWhite.setDoB("20/10/1975");
        CarolWhite.setTimePeriod(TimePeriod.MONTHLY);
        CarolWhite.setStartDate("10/01/2014");
        
        //Create Brad Turner
        SystemAnalyst BradTurner = new SystemAnalyst(ChristineBennet);
        BradTurner.setFirstName("Brad");
        BradTurner.setLastName("Turner");
        BradTurner.setDoB("22/11/1988");
        BradTurner.setTimePeriod(TimePeriod.MONTHLY);
        BradTurner.setStartDate("26/05/2014");
        
        //Creating the Contract Workers
        //Create Helen Chan
        SalesConsultant HelenChan = new SalesConsultant(MichaelBrown);
        HelenChan.setFirstName("Helen");
        HelenChan.setLastName("Chan");
        HelenChan.setDoB("11/01/1991");
        HelenChan.setIsContractor(Boolean.TRUE);
        
        //Create James Carol
        Tester JamesCarol = new Tester(VictoriaBell);
        JamesCarol.setFirstName("James");
        JamesCarol.setLastName("Carol");
        JamesCarol.setDoB("24/03/1978");
        JamesCarol.setIsContractor(Boolean.TRUE);
        
        //Create Elena Tang
        Tester ElenaTang = new Tester(CharlotteHond);
        ElenaTang.setFirstName("Elena");
        ElenaTang.setLastName("Tang");
        ElenaTang.setDoB("11/02/1969");
        ElenaTang.setIsContractor(Boolean.TRUE);
        
        //Create TessaGreen
        Tester TessaGreen = new Tester(CharlotteHond);
        TessaGreen.setFirstName("Tessa");
        TessaGreen.setLastName("Green");
        TessaGreen.setDoB("31/10/1985");
        TessaGreen.setIsContractor(Boolean.TRUE);
        
        //Create David Chand
        Tester DavidChand = new Tester(ChristineBennet);
        DavidChand.setFirstName("David");
        DavidChand.setLastName("Chan");
        DavidChand.setDoB("11/04/1973");
        DavidChand.setIsContractor(Boolean.TRUE);
        
        //Create the James Mint subordinates list
        ArrayList<ISubordinate> CEOsubordinates = new ArrayList<>();
        CEOsubordinates.add(BillJohns);
        CEOsubordinates.add(EricWhite);
        CEOsubordinates.add(JuliaSmith);
        CEOsubordinates.add(MichaelBrown);
        JamesMint.setSubordinateList(CEOsubordinates);
        
        //Create the Bill Johns subordinate list
        ArrayList<ISubordinate> BJSubordinates = new ArrayList<>();
        BJSubordinates.add(KateHudson);
        BJSubordinates.add(ScarletGreen);
        BJSubordinates.add(AmandaGreen);
        BillJohns.setSubordinates(BJSubordinates);
        
        //Create the John Norton subordintate list
        ArrayList<ISubordinate> JNSubordinates = new ArrayList<>();
        JNSubordinates.add(AlexDillon);        
        JohnNorton.setSubordinates(JNSubordinates);
        
        //Create the Ashley Simpson subordinates list
        ArrayList<ISubordinate> ASSubordinates = new ArrayList<>();
        ASSubordinates.add(AndrewSampson);
        AshleySimpson.setSubordinates(ASSubordinates);
        
        //Create the Christine Bennet subordinates list
        ArrayList<ISubordinate> CBSubordinates = new ArrayList<>();
        CBSubordinates.add(DavidGalloway);
        CBSubordinates.add(BradTurner);
        CBSubordinates.add(DavidChand);
        ChristineBennet.setSubordinates(CBSubordinates);
        
        //Create the Amanda Green subordinates list
        ArrayList<ISubordinate> AGSubordinates = new ArrayList<>();
        AGSubordinates.add(VictoriaBell);
        AGSubordinates.add(AndrewBlack);
        AmandaGreen.setSubordinates(AGSubordinates);
        
        //Create the Kate Hudson subordinates list
        ArrayList<ISubordinate> KHSubordinates = new ArrayList<>();
        KHSubordinates.add(CharlotteHond);
        KHSubordinates.add(JoanneDowman);
        KateHudson.setSubordinates(KHSubordinates);
        
        //Create the Scarlet Green subordinates list
        ArrayList<ISubordinate> SGSubordinates = new ArrayList<>();
        SGSubordinates.add(ChristineBennet);
        SGSubordinates.add(MichaelPerry);
        ScarletGreen.setSubordinates(SGSubordinates);
        
        //Create the Julia Smith subordinates list
        ArrayList<ISubordinate> JSSubordinates = new ArrayList<>();
        JSSubordinates.add(PeterGordon);
        JuliaSmith.setSubordinates(JSSubordinates);
        
        //Create the Michael Brown subordinates list
        ArrayList<ISubordinate> MBSubordinates = new ArrayList<>();
        MBSubordinates.add(HelenChan);
        MichaelBrown.setSubordinates(MBSubordinates);
        
        //Create the Victoria Bell subordinates list
        ArrayList<ISubordinate> VBSubordinates = new ArrayList<>();
        VBSubordinates.add(JohnNorton);
        VBSubordinates.add(AndrewBlank);
        VBSubordinates.add(JamesCarol);
        VictoriaBell.setSubordinates(VBSubordinates);
        
        //Create the Charlotte Hond subordinates list
        ArrayList<ISubordinate> CHSubordinates = new ArrayList<>();
        CHSubordinates.add(AshleySimpson);
        CHSubordinates.add(CarolWhite);
        CHSubordinates.add(ElenaTang);
        CHSubordinates.add(TessaGreen);
        CharlotteHond.setSubordinates(CHSubordinates);
        
        //Add the employees to the staff list array
        staffList.add(JamesMint);
        staffList.add(BillJohns);
        staffList.add(KateHudson);
        staffList.add(ScarletGreen);
        staffList.add(AmandaGreen);
        staffList.add(EricWhite);
        staffList.add(JuliaSmith);
        staffList.add(VictoriaBell);
        staffList.add(CharlotteHond);
        staffList.add(ChristineBennet);
        staffList.add(JohnNorton);
        staffList.add(AshleySimpson);
        staffList.add(AlexDillon);
        staffList.add(AndrewSampson);
        staffList.add(DavidGalloway);
        staffList.add(PeterGordon);
        staffList.add(MichaelBrown);
        staffList.add(AndrewBlack);
        staffList.add(JoanneDowman);
        staffList.add(MichaelPerry);
        staffList.add(AndrewBlank);
        staffList.add(CarolWhite);
        staffList.add(BradTurner);
        staffList.add(HelenChan);
        staffList.add(JamesCarol);
        staffList.add(ElenaTang);
        staffList.add(TessaGreen);
        staffList.add(DavidChand);
        
        MainForm startForm = new MainForm(staffList);
        startForm.setVisible(true);
        
        
           
    }
    
        
//    public static void startingPoint(){
//        
//        startForm.setVisible(true);
//        startForm.setLocation(150, 150);
//        startForm.setSize(600, 500);
//                        
//        bonusForm.setVisible(false);
//        bonusForm.setLocation(150, 150);
//        bonusForm.setSize(600, 500);
//                
//        personalInfoForm.setVisible(false);
//        personalInfoForm.setLocation(150, 150);
//        personalInfoForm.setSize(750, 700);
//                        
//        createPaymentsForm.setVisible(false);
//        createPaymentsForm.setLocation(150, 150);
//        createPaymentsForm.setSize(600, 500);
//                
//        reportForm.setVisible(false);
//        reportForm.setLocation(150, 150);
//        reportForm.setSize(600, 500);
//    }
//    
//    public static void hideStartForm(){
//        startForm.setVisible(false);
//    }
//    
//    public static void openStartForm(){
//       
//    }
//    
//    public static void openBonusForm(){
//        startForm.setVisible(false);
//        bonusForm.setVisible(true);
//    }
//    
//    public static void openPersonalInfoForm(){
//        startForm.setVisible(false);
//        personalInfoForm.setVisible(true);
//    }
//    
//    public static void openCreatePaymentsForm(){
//        startForm.setVisible(false);
//        createPaymentsForm.setVisible(true);
//    }
//    
//    public static void openReportForm(){
//        startForm.setVisible(false);
//        reportForm.setVisible(true);
//    }
}
