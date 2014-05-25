package PROZE.EntitiesModels;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D35075BF-A6C6-93A6-021D-27B9CA3D8A0B]
// </editor-fold> 
public abstract class Question {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D04C15D6-BF6B-730F-8208-BB08CB6DF3C9]
    // </editor-fold> 
    protected int ID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5D2B5452-C376-47DC-162F-0211028656E7]
    // </editor-fold> 
    private String content;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.019769EF-D258-2A9B-A14C-DC8DF00293B3]
    // </editor-fold> 
    private Scoring scoring;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.216403D2-3D78-4FC0-66B7-F280F4D13C2B]
    // </editor-fold> 
    public Question (String content, Scoring scoring) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D1F8F431-B275-23E9-D873-D207014A26F8]
    // </editor-fold> 
    public int getID () {
        return ID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D31DECE2-CC5D-736B-38D9-1F54A57A8BB4]
    // </editor-fold> 
    public String getContent () {
        return content;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.45DC423F-B4FD-170A-6F18-89EE98A404DA]
    // </editor-fold> 
    public void setContent (String val) {
        this.content = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.97022D86-A3D1-8477-4935-67B2F2DF3155]
    // </editor-fold> 
    public Scoring getScoring () {
        return scoring;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.853874B8-7D2E-8F5E-B12C-45F050F61688]
    // </editor-fold> 
    public void setScoring (Scoring val) {
        this.scoring = val;
    }

}

