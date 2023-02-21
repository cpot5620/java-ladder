package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    @Test
    void 참가자들의_이름을_반환한다() {
        final Players players = getPlayers("name1", "name2");
        LadderGame ladderGame = new LadderGame(new TestBooleanGenerator(List.of(true, true)), players, new Height(1));
        assertThat(ladderGame.getPlayerNames()).containsExactly("name1", "name2");
    }

    @Test
    void 생성된_사다리를_반환한다() {
        final Players players = getPlayers("name1", "name2");
        LadderGame ladderGame = new LadderGame(new TestBooleanGenerator(List.of(true, true)), players, new Height(2));
        assertThat(ladderGame.getLadder())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(LineStatus.CONNECTED),
                        List.of(LineStatus.CONNECTED)
                );
    }

    private static Players getPlayers(String... playerNames) {
        return new Players(List.of(playerNames));
    }
}