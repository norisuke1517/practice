package trump;

/**
 * トランプルールインターフェース
 * 現在の手札とテーブルから、出しうるカードの組み合わせを見つける
 */
public interface Rule {
    /**
     * テーブルにおけるカードを探す
     * 
     * @param hand
     * @param table
     * @return 見つかったカードの組み合わせ。見つからなかったらnull
     */
    public Card[] findCandidate(Hand hand, Table table);
}
