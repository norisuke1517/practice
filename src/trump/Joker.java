package trump;

/**
 * ジョーカークラス
 * Cardクラスを継承
 */
public class Joker extends Card {

    /**
     * コンストラクタ
     * デフォルトではジョーカーは何の値、スートも返さない
     */
    public Joker() {
        super(0, 0);
    }

    /**
     * 数を変更
     * 
     * @param number 数
     */
    public void setNumber(int number) {
        this.number_ = number;
    }

    /**
     * スートを変更
     * 
     * @param suit スート
     */
    public void setSuit(int suit) {
        this.suit_ = suit;
    }

    /**
     * カードを文字列で表現
     * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド
     * 
     * @return カードの文字列表現
     */
    public String toString() {
        return "JK";
    }
}
