/**
 * プレイヤークラス
 */
public class Player {
    /**
     * 進行役
     */
    private Master master_;

    /**
     * テーブル
     */
    private Table table_;

    /**
     * 手札
     */
    private Hand myHand_ = new Hand();

    /**
     * 名前
     */
    private String name_;

    /**
     * コンストラクタ
     */
    public Player(String name, Master master, Table table) {
        this.name_ = name;
        this.master_ = master;
        this.table_ = table;
    }

    /**
     * 手札を見せる
     * 
     * @return 自分の手札
     */
    public Hand showHand() {
        if (myHand_.getNumberOfCards() == 1) {
            master_.declareWin(this);
        }

        // 見せる前にシャッフル
        myHand_.shuffle();

        return myHand_;
    }

    /**
     * 順番を指名
     * 
     * @param nextPlayer 次のプレイヤー
     */
    public void Play(Player nextPlayer) {
        // 次のプレイヤーに手札を出してもらう
        Hand nextHand = nextPlayer.showHand();

        // 相手の手札からカードを一枚ひく
        Card pickedCard = nextHand.pickCard();

        // 引いたカードを表示
        System.out.println(this + ":" + nextPlayer + "さんから " + pickedCard + " を引きました");

        // 引いたカードを自分の手札に加え、同じカードがあったら捨てる
        dealCard(pickedCard);

        // 手札が0になったかどうか調べる
        if (myHand_.getNumberOfCards() == 0) {
            master_.declareWin(this);
        } else {
            // 現在の手札を表す
            System.out.println(this + ":残りの手札は " + myHand_ + " です");
        }
    }

    /**
     * カードを受け取る
     * 
     * @param card 受け取ったカード
     */
    public void receiveCard(Card card) {
        // 引いたカードを自分の手札に加え、同じカードがあったら捨てる
        dealCard(card);
    }

    /**
     * 引いたカードを自分の手札に加え、同じカードがあったら捨てる
     * 
     * @param card
     */
    private void dealCard(Card card) {
        // カードを自分の手札に加える
        myHand_.addCard(card);

        // 加えたカードと同じカードを探す
        Card[] sameCards = myHand_.findSameNumberCard();

        if (sameCards != null) {
            // テーブルへカードを捨てる
            System.out.println(this + ":");
            table_.disposeCards(sameCards);
        }
    }

    /**
     * プレイヤーの名前を返す
     * 
     * @return プレイヤーの名前
     */
    public String toString() {
        return name_;
    }
}
