package TicTacToe.model;




public class CurPlayer {
    private Player p1;
    private Player p2;
    private Player curPlayer;

    public CurPlayer(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        curPlayer = p1;
    }
    public Player getCurPlayer() {
        return this.curPlayer;
    }

    public void setCurPlayer (Player player) {
        this.curPlayer = player;
    }
    public void SwitchCurPlayer() {
        curPlayer = curPlayer == p1 ? p2 : p1;
    }

    public Player getSwitchedCurPlayer(){
        this.SwitchCurPlayer();
        return getCurPlayer();
    }
}