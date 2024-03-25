package trump;

/**
 * プレイヤークラス
 */
public abstract class Player {
    /**
     * 進行役
     */
    protected Master master_;

    /**
     * テーブル
     */
    protected Table table_;

    /**
     * 手札
     */
    protected Hand myHand_ = new Hand();

    /**
     * 名前
     */
    protected String name_;

    /**
     * ルール
     */
    protected Rule rule_;

    /**
     * コンストラクタ
     */
    public Player(String name, Master master, Table table, Rule rule) {
        this.name_ = name;
        this.master_ = master;
        this.table_ = table;
        this.rule_ = rule;
    }

    /**
     * 順番を指名
     * 実際の処理はサブクラスに実装
     * 
     * @param nextPlayer 次のプレイヤー
     */
    public abstract void Play(Player nextPlayer);

    /**
     * カードを配る
     * カードを受け取った時の処理を拡張したい場合は
     * 本メソッドをサブクラスでオーバーライドすること
     * 
     * @param card 受け取ったカード
     */
    public void receiveCard(Card card) {
        // 受け取ったカードを手札に加える
        myHand_.addCard(card);
    }

    /**
     * プレイヤーの名前を返す
     * objectクラスのtoStringメソッドをオーバーライドしたメソッド
     * 
     * @return プレイヤーの名前
     */
    public String toString() {
        return name_;
    }
}
