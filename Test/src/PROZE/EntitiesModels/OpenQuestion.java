package PROZE.EntitiesModels;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3AAFED2D-6A27-F7DA-7B4D-4A4A482790F2]
// </editor-fold> 
public class OpenQuestion extends Question {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.964A2D57-490F-4831-DCB4-B3660F65D20F]
    // </editor-fold> 
    private String answer;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4EA707C9-206A-80EA-829D-E2D42BECD829]
    // </editor-fold> 
    public OpenQuestion(String content, Scoring scoring, String answer) {
        super(content, scoring);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3F49E622-8047-32BD-444C-1D58DA9925EE]
    // </editor-fold> 
    public String getAnswer() {
        return answer;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BC810B1E-C108-2DD4-F657-245A7F1A5601]
    // </editor-fold> 
    public void setAnswer(String val) {
        this.answer = val;
    }

}
