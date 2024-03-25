package trump;

import java.util.ArrayList;

/**
 * 進行役を表すクラス
 */
public class Master {
    // プレイヤーのリスト
    private ArrayList players_ = new ArrayList();

    /**
     * ゲームの準備をする
     */
    public void prepareGame(Hand cards) {
        System.out.println("【カードを配ります】");

        // トランプをシャッフルする
        cards.shuffle();

        // トランプの枚数を取得する
        int numberOfCards = cards.getNumberOfCards();

        // プレイヤーの人数を取得する
        int numberOfPlayers = players_.size();

        for (int index = 0; index < numberOfCards; index++) {
            // カードから1枚引く
            Card card = cards.pickCard(0);

            // 各プレイヤーに順番に配る
            Player player = (Player) players_.get(index % numberOfPlayers);
            player.receiveCard(card);
        }
    }

    /**
     * ゲームを開始する
     */
    public void startGame() {
        System.out.println("【ゲームを開始します】");

        // プレイヤーの人数を取得する
        for (int count = 0; players_.size() > 1; count++) {
            int playerIndex = count % players_.size();
            int nextPlayerIndex = (count + 1) % players_.size();

            // 指名するプレイヤーの取得
            Player player = (Player) players_.get(playerIndex);

            // 次のプレイヤーの取得
            Player nextPlayer = (Player) players_.get(nextPlayerIndex);

            // プレイヤーを指名する
            System.out.println("￥n" + player + "さんの番です");
            player.Play(nextPlayer);
        }

        // プレイヤーが上がって残り1名になるとループを抜ける
        System.out.println("【ゲームを終了しました】");
    }

    /**
     * 上がりを宣言する
     */
    public void declareWin(Player winner) {
        // 上がったプレイヤー
        System.out.println(winner + "さんが上がりました！");

        // 上がったプレイヤーをリストから外す
        deregisterPlayer(winner);
    }

    /**
     * ゲームに参加するプレイヤーを登録
     * 
     * @param player
     */
    public void registerPlayer(Player player) {
        // リストに参加する参加者を追加する
        players_.add(player);
    }

    /**
     * ゲームに参加するプレイヤーを登録から削除する
     * 
     * @param player
     */
    public void deregisterPlayer(Player player) {
        // リストから参加者を削除する
        players_.remove(players_.indexOf(player));

        // 残りプレイヤーが1人になったときは敗者を表示
        if (players_.size() == 1) {
            Player loser = (Player) players_.get(0);
            System.out.println(" " + loser + "さんの負けです");
        }
    }
}
