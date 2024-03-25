import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;
import trump.Table;

public class App {
    public static void main(String[] args) throws Exception {
        // 進行役
        Master master = new Master();

        // テーブル
        Table field = new Table();

        // プレイヤー
        Player norimasa = new Player("のりまさ", master, field);
        Player satomi = new Player("さとみ", master, field);
        Player honoka = new Player("ほのか", master, field);

        // 進行役へプレイヤーを登録
        master.registerPlayer(norimasa);
        master.registerPlayer(satomi);
        master.registerPlayer(honoka);

        // トランプ
        Hand trump = createTrump();

        // ゲームの準備
        master.prepareGame(trump);

        // ゲーム開始
        master.startGame();
    }

    /**
     * 53枚のトランプを準備
     * 
     * @return トランプを格納したHand
     */
    private static Hand createTrump() {
        Hand trump = new Hand();

        // 各スート53枚のカードを生成
        for (int number = 1; number <= 13; number++) {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));
        }

        // ジョーカーの生成
        trump.addCard(new Card(0, Card.JOKER));

        return trump;
    }

}
