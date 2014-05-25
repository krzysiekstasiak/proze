package PROZE.EntitiesModels;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.375DFF2C-0E4B-213B-D202-A2A72999742F]
// </editor-fold> 
public class Scoring {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EBA0AA60-48FF-096C-5455-C780FAD9AFCA]
    // </editor-fold> 
    private int pointsForCorrect;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.16847D04-7B03-F89B-B1E7-52A38D732C19]
    // </editor-fold> 
    private int pointsForNoAnswer;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B18980E1-50F9-5618-DEB0-5D15538F4DEB]
    // </editor-fold> 
    private int pointsForWrongAnswer;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E036D6F8-A207-A5B3-5E4F-4DA8218BD98B]
    // </editor-fold> 
    private int timePerQuestion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1BEC56C4-7FCF-2608-C28F-2C27EC469846]
    // </editor-fold> 
    public Scoring () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.449B19BF-5B51-6FCC-F2B4-EB4A3CDB54E7]
    // </editor-fold> 
    public int getPointsForCorrect () {
        return pointsForCorrect;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.87EFA9B8-3538-3D12-75DA-A406DFEB1AA6]
    // </editor-fold> 
    public void setPointsForCorrect (int val) {
        this.pointsForCorrect = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FFB5489C-259D-72F0-A65E-66DB83AFFEF1]
    // </editor-fold> 
    public int getPointsForNoAnswer () {
        return pointsForNoAnswer;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B5DBB7B1-60C3-4E3F-D5CF-0CA25828C7F0]
    // </editor-fold> 
    public void setPointsForNoAnswer (int val) {
        this.pointsForNoAnswer = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A98ECF48-86C6-BB04-3F74-3847DC1E6C30]
    // </editor-fold> 
    public int getPointsForWrongAnswer () {
        return pointsForWrongAnswer;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B5D5BF69-54E0-DCD4-0EB1-54C26D898525]
    // </editor-fold> 
    public void setPointsForWrongAnswer (int val) {
        this.pointsForWrongAnswer = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.653AC391-5C76-33F4-98D8-337D790E4B8B]
    // </editor-fold> 
    public int getTimePerQuestion () {
        return timePerQuestion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1F241F7A-1F95-C58C-B85A-4D29D24493ED]
    // </editor-fold> 
    public void setTimePerQuestion (int val) {
        this.timePerQuestion = val;
    }

}

