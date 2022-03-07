/*  Main Controller Code
 *  Holds functions for all buttons and scene management.
 */

package com.example.connectfour;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int lastPiece;
    private final ImageView[][] board = new ImageView[6][7];
    private final ImageView[][] border = new ImageView[6][7];
    @FXML private AnchorPane gameScene;
    @FXML private ImageView oneOne;
    @FXML private ImageView oneTwo;
    @FXML private ImageView oneThree;
    @FXML private ImageView oneFour;
    @FXML private ImageView oneFive;
    @FXML private ImageView oneSix;
    @FXML private ImageView twoOne;
    @FXML private ImageView twoTwo;
    @FXML private ImageView twoThree;
    @FXML private ImageView twoFour;
    @FXML private ImageView twoFive;
    @FXML private ImageView twoSix;
    @FXML private ImageView threeOne;
    @FXML private ImageView threeTwo;
    @FXML private ImageView threeThree;
    @FXML private ImageView threeFour;
    @FXML private ImageView threeFive;
    @FXML private ImageView threeSix;
    @FXML private ImageView fourOne;
    @FXML private ImageView fourTwo;
    @FXML private ImageView fourThree;
    @FXML private ImageView fourFour;
    @FXML private ImageView fourFive;
    @FXML private ImageView fourSix;
    @FXML private ImageView fiveOne;
    @FXML private ImageView fiveTwo;
    @FXML private ImageView fiveThree;
    @FXML private ImageView fiveFour;
    @FXML private ImageView fiveFive;
    @FXML private ImageView fiveSix;
    @FXML private ImageView sixOne;
    @FXML private ImageView sixTwo;
    @FXML private ImageView sixThree;
    @FXML private ImageView sixFour;
    @FXML private ImageView sixFive;
    @FXML private ImageView sixSix;
    @FXML private ImageView sevenOne;
    @FXML private ImageView sevenTwo;
    @FXML private ImageView sevenThree;
    @FXML private ImageView sevenFour;
    @FXML private ImageView sevenFive;
    @FXML private ImageView sevenSix;
    @FXML private ImageView oneOne1;
    @FXML private ImageView oneTwo1;
    @FXML private ImageView oneThree1;
    @FXML private ImageView oneFour1;
    @FXML private ImageView oneFive1;
    @FXML private ImageView oneSix1;
    @FXML private ImageView twoOne1;
    @FXML private ImageView twoTwo1;
    @FXML private ImageView twoThree1;
    @FXML private ImageView twoFour1;
    @FXML private ImageView twoFive1;
    @FXML private ImageView twoSix1;
    @FXML private ImageView threeOne1;
    @FXML private ImageView threeTwo1;
    @FXML private ImageView threeThree1;
    @FXML private ImageView threeFour1;
    @FXML private ImageView threeFive1;
    @FXML private ImageView threeSix1;
    @FXML private ImageView fourOne1;
    @FXML private ImageView fourTwo1;
    @FXML private ImageView fourThree1;
    @FXML private ImageView fourFour1;
    @FXML private ImageView fourFive1;
    @FXML private ImageView fourSix1;
    @FXML private ImageView fiveOne1;
    @FXML private ImageView fiveTwo1;
    @FXML private ImageView fiveThree1;
    @FXML private ImageView fiveFour1;
    @FXML private ImageView fiveFive1;
    @FXML private ImageView fiveSix1;
    @FXML private ImageView sixOne1;
    @FXML private ImageView sixTwo1;
    @FXML private ImageView sixThree1;
    @FXML private ImageView sixFour1;
    @FXML private ImageView sixFive1;
    @FXML private ImageView sixSix1;
    @FXML private ImageView sevenOne1;
    @FXML private ImageView sevenTwo1;
    @FXML private ImageView sevenThree1;
    @FXML private ImageView sevenFour1;
    @FXML private ImageView sevenFive1;
    @FXML private ImageView sevenSix1;
    @FXML private Button colOneButton;
    @FXML private Button colTwoButton;
    @FXML private Button colThreeButton;
    @FXML private Button colFourButton;
    @FXML private Button colFiveButton;
    @FXML private Button colSixButton;
    @FXML private Button colSevenButton;
    @FXML private ImageView playerTurnIndicator;
    @FXML private Label playerTurnLabel;
    @FXML private Label p1Wins;
    @FXML private Label p2Wins;
    @FXML private Label ties;
    @FXML private Button backToMenu;
    @FXML private Button gameExit;
    @FXML private Button saveGame;
    @FXML private ImageView MainMenuButtonImage;
    @FXML private ImageView SaveGameButtonImage;
    @FXML private ImageView ExitGameButtonImage;
    @FXML private ImageView NewGameButtonImage;
    @FXML private ImageView LoadGameButtonImage;
    @FXML private ImageView OptionsMenuButtonImage;
    @FXML private ImageView HelpMenuButtonImage;
    @FXML private ImageView MenuExitButtonImage;
    private final Image redSide =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/pieces/ConnectRed.png")));
    private Image turnColor = redSide;
    private final Image defaultBorder =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/borders/BlueBorder.png")));
    private final Image yelSide =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/pieces/ConnectYellow.png")));
    private final Image blank =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/pieces/ConnectBlank.png")));
    private final Image redWinBorder =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/borders/YellowBorder.png")));
    private final Image yellowWinBorder =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/borders/RedBorder.png")));
    private final Image winRed =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/pieces/ConnectWinRed.gif")));
    private final Image winYel =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/pieces/ConnectWinYellow.gif")));
    private final Image pressedButton =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/misc/buttonPressed.png")));
    private final Image unpressedButton =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/misc/button.png")));

    public void button1() { buttonCheck(1); }
    public void button2() { buttonCheck(2); }
    public void button3() { buttonCheck(3); }
    public void button4() { buttonCheck(4); }
    public void button5() { buttonCheck(5); }
    public void button6() { buttonCheck(6); }
    public void button7() { buttonCheck(7); }

    private boolean firstTurn = true;
    // Main code for handling pieces being dropped, will set validPlay to false if an illegal move is detected
    public void buttonCheck(int input) {
        populateWinCheckArray();
        if (firstTurn) {
            firstTurn = false;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    board[i][j].setImage(blank);
                }
            }
        }
        boolean validPlay = true;
        switch (input) {
            case 1:
                if (oneSix.getImage() != blank) {
                    if (oneFive.getImage() != blank) {
                        if (oneFour.getImage() != blank) {
                            if (oneThree.getImage() != blank) {
                                if (oneTwo.getImage() != blank) {
                                    if (oneOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 1;
                                    }
                                } else {
                                    lastPiece = 2;
                                }
                            } else {
                                lastPiece = 3;
                            }
                        } else {
                            lastPiece = 4;
                        }
                    } else {
                        lastPiece = 5;
                    }
                } else {
                    lastPiece = 6;
                }
                break;
            case 2:
                if (twoSix.getImage() != blank) {
                    if (twoFive.getImage() != blank) {
                        if (twoFour.getImage() != blank) {
                            if (twoThree.getImage() != blank) {
                                if (twoTwo.getImage() != blank) {
                                    if (twoOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 7;
                                    }
                                } else {
                                    lastPiece = 8;
                                }
                            } else {
                                lastPiece = 9;
                            }
                        } else {
                            lastPiece = 10;
                        }
                    } else {
                        lastPiece = 11;
                    }
                } else {
                    lastPiece = 12;
                }
                break;
            case 3:
                if (threeSix.getImage() != blank) {
                    if (threeFive.getImage() != blank) {
                        if (threeFour.getImage() != blank) {
                            if (threeThree.getImage() != blank) {
                                if (threeTwo.getImage() != blank) {
                                    if (threeOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 13;
                                    }
                                } else {
                                    lastPiece = 14;
                                }
                            } else {
                                lastPiece = 15;
                            }
                        } else {
                            lastPiece = 16;
                        }
                    } else {
                        lastPiece = 17;
                    }
                } else {
                    lastPiece = 18;
                }
                break;
            case 4:
                if (fourSix.getImage() != blank) {
                    if (fourFive.getImage() != blank) {
                        if (fourFour.getImage() != blank) {
                            if (fourThree.getImage() != blank) {
                                if (fourTwo.getImage() != blank) {
                                    if (fourOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 19;
                                    }
                                } else {
                                    lastPiece = 20;
                                }
                            } else {
                                lastPiece = 21;
                            }
                        } else {
                            lastPiece = 22;
                        }
                    } else {
                        lastPiece = 23;
                    }
                } else {
                    lastPiece = 24;
                }
                break;
            case 5:
                if (fiveSix.getImage() != blank) {
                    if (fiveFive.getImage() != blank) {
                        if (fiveFour.getImage() != blank) {
                            if (fiveThree.getImage() != blank) {
                                if (fiveTwo.getImage() != blank) {
                                    if (fiveOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 25;
                                    }
                                } else {
                                    lastPiece = 26;
                                }
                            } else {
                                lastPiece = 27;
                            }
                        } else {
                            lastPiece = 28;
                        }
                    } else {
                        lastPiece = 29;
                    }
                } else {
                    lastPiece = 30;
                }
                break;
            case 6:
                if (sixSix.getImage() != blank) {
                    if (sixFive.getImage() != blank) {
                        if (sixFour.getImage() != blank) {
                            if (sixThree.getImage() != blank) {
                                if (sixTwo.getImage() != blank) {
                                    if (sixOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 31;
                                    }
                                } else {
                                    lastPiece = 32;
                                }
                            } else {
                                lastPiece = 33;
                            }
                        } else {
                            lastPiece = 34;
                        }
                    } else {
                        lastPiece = 35;
                    }
                } else {
                    lastPiece = 36;
                }
                break;
            case 7:
                if (sevenSix.getImage() != blank) {
                    if (sevenFive.getImage() != blank) {
                        if (sevenFour.getImage() != blank) {
                            if (sevenThree.getImage() != blank) {
                                if (sevenTwo.getImage() != blank) {
                                    if (sevenOne.getImage() != blank) {
                                        validPlay = false;
                                    } else {
                                        lastPiece = 37;
                                    }
                                } else {
                                    lastPiece = 38;
                                }
                            } else {
                                lastPiece = 39;
                            }
                        } else {
                            lastPiece = 40;
                        }
                    } else {
                        lastPiece = 41;
                    }
                } else {
                    lastPiece = 42;
                }
                break;
        }
        dropPiece(validPlay);
    }

    public void validMoveMade() {
        colOneButton.setDisable(false);
        colTwoButton.setDisable(false);
        colThreeButton.setDisable(false);
        colFourButton.setDisable(false);
        colFiveButton.setDisable(false);
        colSixButton.setDisable(false);
        colSevenButton.setDisable(false);

        // Will swap turns if a valid move is made and checks for a win
        turnColor = turnColor == redSide ? yelSide : redSide;
        playerTurnIndicator.setImage(turnColor);
        if (turnColor == redSide) playerTurnLabel.setText("Player One's Turn");
        else playerTurnLabel.setText("Player Two's Turn");
        populateWinCheckArray();
        Platform.runLater(this::winCheck);
    }

    // Populates a Circle array with the circles for easier checking in winCheck method
    public void populateWinCheckArray() {
        board[0][0] = oneOne;    board[1][0] = oneTwo;    board[2][0] = oneThree;
        board[3][0] = oneFour;   board[4][0] = oneFive;   board[5][0] = oneSix;
        board[0][1] = twoOne;    board[1][1] = twoTwo;    board[2][1] = twoThree;
        board[3][1] = twoFour;   board[4][1] = twoFive;   board[5][1] = twoSix;
        board[0][2] = threeOne;  board[1][2] = threeTwo;  board[2][2] = threeThree;
        board[3][2] = threeFour; board[4][2] = threeFive; board[5][2] = threeSix;
        board[0][3] = fourOne;   board[1][3] = fourTwo;   board[2][3] = fourThree;
        board[3][3] = fourFour;  board[4][3] = fourFive;  board[5][3] = fourSix;
        board[0][4] = fiveOne;   board[1][4] = fiveTwo;   board[2][4] = fiveThree;
        board[3][4] = fiveFour;  board[4][4] = fiveFive;  board[5][4] = fiveSix;
        board[0][5] = sixOne;    board[1][5] = sixTwo;    board[2][5] = sixThree;
        board[3][5] = sixFour;   board[4][5] = sixFive;   board[5][5] = sixSix;
        board[0][6] = sevenOne;  board[1][6] = sevenTwo;  board[2][6] = sevenThree;
        board[3][6] = sevenFour; board[4][6] = sevenFive; board[5][6] = sevenSix;
    }
    public void populateBorderArray() {
        border[0][0] = oneOne1;    border[1][0] = oneTwo1;    border[2][0] = oneThree1;
        border[3][0] = oneFour1;   border[4][0] = oneFive1;   border[5][0] = oneSix1;
        border[0][1] = twoOne1;    border[1][1] = twoTwo1;    border[2][1] = twoThree1;
        border[3][1] = twoFour1;   border[4][1] = twoFive1;   border[5][1] = twoSix1;
        border[0][2] = threeOne1;  border[1][2] = threeTwo1;  border[2][2] = threeThree1;
        border[3][2] = threeFour1; border[4][2] = threeFive1; border[5][2] = threeSix1;
        border[0][3] = fourOne1;   border[1][3] = fourTwo1;   border[2][3] = fourThree1;
        border[3][3] = fourFour1;  border[4][3] = fourFive1;  border[5][3] = fourSix1;
        border[0][4] = fiveOne1;   border[1][4] = fiveTwo1;   border[2][4] = fiveThree1;
        border[3][4] = fiveFour1;  border[4][4] = fiveFive1;  border[5][4] = fiveSix1;
        border[0][5] = sixOne1;    border[1][5] = sixTwo1;    border[2][5] = sixThree1;
        border[3][5] = sixFour1;   border[4][5] = sixFive1;   border[5][5] = sixSix1;
        border[0][6] = sevenOne1;  border[1][6] = sevenTwo1;  border[2][6] = sevenThree1;
        border[3][6] = sevenFour1; border[4][6] = sevenFive1; border[5][6] = sevenSix1;
    }

    private boolean win = false;
    // Checks around the last piece played for all 16 win conditions
    public void winCheck() {
        lastPiece--;
        populateBorderArray();
        int row = lastPiece % 6;
        int col = lastPiece / 6;
        Image winBorder = turnColor == redSide ? redWinBorder : yellowWinBorder;
        Image winSpin = turnColor == redSide ? winYel : winRed;
        if (board[row][col].getImage() != blank) {
            if (
                    row > 2 &&
                        board[row][col].getImage() == board[row - 1][col].getImage() &&
                        board[row][col].getImage() == board[row - 2][col].getImage() &&
                        board[row][col].getImage() == board[row - 3][col].getImage()) {
                border[row][col].setImage(winBorder);
                border[row - 1][col].setImage(winBorder);
                border[row - 2][col].setImage(winBorder);
                border[row - 3][col].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row - 1][col].setImage(winSpin);
                board[row - 2][col].setImage(winSpin);
                board[row - 3][col].setImage(winSpin);
                win = true;
            } else if (
                    row < 3 &&
                            board[row][col].getImage() == board[row + 1][col].getImage() &&
                            board[row][col].getImage() == board[row + 2][col].getImage() &&
                            board[row][col].getImage() == board[row + 3][col].getImage()) {
                border[row][col].setImage(winBorder);
                border[row + 1][col].setImage(winBorder);
                border[row + 2][col].setImage(winBorder);
                border[row + 3][col].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row + 1][col].setImage(winSpin);
                board[row + 2][col].setImage(winSpin);
                board[row + 3][col].setImage(winSpin);
                win = true;
            } else if (
                    col > 2 &&
                            board[row][col].getImage() == board[row][col - 1].getImage() &&
                            board[row][col].getImage() == board[row][col - 2].getImage() &&
                            board[row][col].getImage() == board[row][col - 3].getImage()) {
                border[row][col].setImage(winBorder);
                border[row][col - 1].setImage(winBorder);
                border[row][col - 2].setImage(winBorder);
                border[row][col - 3].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row][col - 1].setImage(winSpin);
                board[row][col - 2].setImage(winSpin);
                board[row][col - 3].setImage(winSpin);
                win = true;
            } else if (
                    col < 4 &&
                            board[row][col].getImage() == board[row][col + 1].getImage() &&
                            board[row][col].getImage() == board[row][col + 2].getImage() &&
                            board[row][col].getImage() == board[row][col + 3].getImage()) {
                border[row][col].setImage(winBorder);
                border[row][col + 1].setImage(winBorder);
                border[row][col + 2].setImage(winBorder);
                border[row][col + 3].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row][col + 1].setImage(winSpin);
                board[row][col + 2].setImage(winSpin);
                board[row][col + 3].setImage(winSpin);
                win = true;
            } else if (
                    row < 3 && col < 4 &&
                            board[row][col].getImage() == board[row + 1][col + 1].getImage() &&
                            board[row][col].getImage() == board[row + 2][col + 2].getImage() &&
                            board[row][col].getImage() == board[row + 3][col + 3].getImage()) {
                border[row][col].setImage(winBorder);
                border[row + 1][col + 1].setImage(winBorder);
                border[row + 2][col + 2].setImage(winBorder);
                border[row + 3][col + 3].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row + 1][col + 1].setImage(winSpin);
                board[row + 2][col + 2].setImage(winSpin);
                board[row + 3][col + 3].setImage(winSpin);
                win = true;
            } else if (
                    row < 3 && col > 2 &&
                            board[row][col].getImage() == board[row + 1][col - 1].getImage() &&
                            board[row][col].getImage() == board[row + 2][col - 2].getImage() &&
                            board[row][col].getImage() == board[row + 3][col - 3].getImage()) {
                border[row][col].setImage(winBorder);
                border[row + 1][col - 1].setImage(winBorder);
                border[row + 2][col - 2].setImage(winBorder);
                border[row + 3][col - 3].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row + 1][col - 1].setImage(winSpin);
                board[row + 2][col - 2].setImage(winSpin);
                board[row + 3][col - 3].setImage(winSpin);
                win = true;
            } else if (
                    row > 2 && col < 4 &&
                            board[row][col].getImage() == board[row - 1][col + 1].getImage() &&
                            board[row][col].getImage() == board[row - 2][col + 2].getImage() &&
                            board[row][col].getImage() == board[row - 3][col + 3].getImage()) {
                border[row][col].setImage(winBorder);
                border[row - 1][col + 1].setImage(winBorder);
                border[row - 2][col + 2].setImage(winBorder);
                border[row - 3][col + 3].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row - 1][col + 1].setImage(winSpin);
                board[row - 2][col + 2].setImage(winSpin);
                board[row - 3][col + 3].setImage(winSpin);
                win = true;
            } else if (
                    row > 2 && col > 4 &&
                            board[row][col].getImage() == board[row - 1][col - 1].getImage() &&
                            board[row][col].getImage() == board[row - 2][col - 2].getImage() &&
                            board[row][col].getImage() == board[row - 3][col - 3].getImage()) {
                border[row][col].setImage(winBorder);
                border[row - 1][col - 1].setImage(winBorder);
                border[row - 1][col - 1].setImage(winBorder);
                border[row - 3][col - 3].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row - 1][col - 1].setImage(winSpin);
                board[row - 1][col - 1].setImage(winSpin);
                board[row - 3][col - 3].setImage(winSpin);
                win = true;
            } else if (
                    row < 4 && row > 0 &&
                            board[row][col].getImage() == board[row - 1][col].getImage() &&
                            board[row][col].getImage() == board[row + 1][col].getImage() &&
                            board[row][col].getImage() == board[row + 2][col].getImage()) {
                border[row][col].setImage(winBorder);
                border[row - 1][col].setImage(winBorder);
                border[row + 1][col].setImage(winBorder);
                border[row + 2][col].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row - 1][col].setImage(winSpin);
                board[row + 1][col].setImage(winSpin);
                board[row + 2][col].setImage(winSpin);
                win = true;
            } else if (
                    row > 1 && row < 5 &&
                            board[row][col].getImage() == board[row + 1][col].getImage() &&
                            board[row][col].getImage() == board[row - 1][col].getImage() &&
                            board[row][col].getImage() == board[row - 2][col].getImage()) {
                border[row][col].setImage(winBorder);
                border[row + 1][col].setImage(winBorder);
                border[row - 1][col].setImage(winBorder);
                border[row - 2][col].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row + 1][col].setImage(winSpin);
                board[row - 1][col].setImage(winSpin);
                board[row - 2][col].setImage(winSpin);
                win = true;
            } else if (
                    col < 5 && col > 0 &&
                            board[row][col].getImage() == board[row][col - 1].getImage() &&
                            board[row][col].getImage() == board[row][col + 1].getImage() &&
                            board[row][col].getImage() == board[row][col + 2].getImage()) {
                border[row][col].setImage(winBorder);
                border[row][col - 1].setImage(winBorder);
                border[row][col + 1].setImage(winBorder);
                border[row][col + 2].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row][col - 1].setImage(winSpin);
                board[row][col + 1].setImage(winSpin);
                board[row][col + 2].setImage(winSpin);
                win = true;
            } else if (
                    col > 1 && col < 6 &&
                            board[row][col].getImage() == board[row][col + 1].getImage() &&
                            board[row][col].getImage() == board[row][col - 1].getImage() &&
                            board[row][col].getImage() == board[row][col - 2].getImage()) {
                border[row][col].setImage(winBorder);
                border[row][col + 1].setImage(winBorder);
                border[row][col - 1].setImage(winBorder);
                border[row][col - 2].setImage(winBorder);
                border[row][col].setImage(winBorder);
                border[row][col + 1].setImage(winBorder);
                border[row][col - 1].setImage(winBorder);
                border[row][col - 2].setImage(winBorder);
                win = true;
            } else if (
                    row < 4 && row > 0 && col < 5 && col > 0 &&
                            board[row][col].getImage() == board[row - 1][col - 1].getImage() &&
                            board[row][col].getImage() == board[row + 1][col + 1].getImage() &&
                            board[row][col].getImage() == board[row + 2][col + 2].getImage()) {
                border[row][col].setImage(winBorder);
                border[row - 1][col - 1].setImage(winBorder);
                border[row + 1][col + 1].setImage(winBorder);
                border[row + 2][col + 2].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row - 1][col - 1].setImage(winSpin);
                board[row + 1][col + 1].setImage(winSpin);
                board[row + 2][col + 2].setImage(winSpin);
                win = true;
            } else if (
                    row > 1 && row < 5 && col < 5 && col > 0 &&
                            board[row][col].getImage() == board[row + 1][col - 1].getImage() &&
                            board[row][col].getImage() == board[row - 1][col + 1].getImage() &&
                            board[row][col].getImage() == board[row - 2][col + 2].getImage()) {
                border[row][col].setImage(winBorder);
                border[row + 1][col - 1].setImage(winBorder);
                border[row - 1][col + 1].setImage(winBorder);
                border[row - 2][col + 2].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row + 1][col - 1].setImage(winSpin);
                board[row - 1][col + 1].setImage(winSpin);
                board[row - 2][col + 2].setImage(winSpin);
                win = true;
            } else if (
                    row < 4 && row > 0 && col > 1 && col < 6 &&
                            board[row][col].getImage() == board[row - 1][col + 1].getImage() &&
                            board[row][col].getImage() == board[row + 1][col - 1].getImage() &&
                            board[row][col].getImage() == board[row + 2][col - 2].getImage()) {
                border[row][col].setImage(winBorder);
                border[row - 1][col + 1].setImage(winBorder);
                border[row + 1][col - 1].setImage(winBorder);
                border[row + 2][col - 2].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row - 1][col + 1].setImage(winSpin);
                board[row + 1][col - 1].setImage(winSpin);
                board[row + 2][col - 2].setImage(winSpin);
                win = true;
            } else if (
                    row > 1 && row < 5 && col > 1 && col < 6 &&
                            board[row][col].getImage() == board[row + 1][col + 1].getImage() &&
                            board[row][col].getImage() == board[row - 1][col - 1].getImage() &&
                            board[row][col].getImage() == board[row - 2][col - 2].getImage()) {
                border[row][col].setImage(winBorder);
                border[row + 1][col + 1].setImage(winBorder);
                border[row - 1][col - 1].setImage(winBorder);
                border[row - 2][col - 2].setImage(winBorder);
                board[row][col].setImage(winSpin);
                board[row + 1][col + 1].setImage(winSpin);
                board[row - 1][col - 1].setImage(winSpin);
                board[row - 2][col - 2].setImage(winSpin);
                win = true;
            }
        }
        // If a win is detected, displays the winner and sets circle strokes to display the winning move
        // Disables all button input while an alert popup asks user if they want to play again
        if (win) {
            turnColor = turnColor == redSide ? yelSide : redSide;
            if (turnColor == redSide) playerTurnLabel.setText("Player One Wins!");
            else playerTurnLabel.setText("Yellow player wins!");
            playerTurnIndicator.setImage(turnColor);
            if (turnColor == redSide) {
                p1Wins.setText(Integer.toString(Integer.parseInt(p1Wins.getText()) + 1));
            } else {
                p2Wins.setText(Integer.toString(Integer.parseInt(p2Wins.getText()) + 1));
            }

            colOneButton.setDisable(true);
            colTwoButton.setDisable(true);
            colThreeButton.setDisable(true);
            colFourButton.setDisable(true);
            colFiveButton.setDisable(true);
            colSixButton.setDisable(true);
            colSevenButton.setDisable(true);
            backToMenu.setDisable(true);
            gameExit.setDisable(true);
            saveGame.setDisable(true);
            win = false;

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (turnColor == redSide) alert.setTitle("Player One Wins!");
            else alert.setTitle("Player Two Wins!");
            alert.setHeaderText("Would you like to play again?");

            // Resets board if the user wants to play again
            if (alert.showAndWait().get() == ButtonType.OK) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        board[i][j].setImage(blank);
                    }
                }

                if (turnColor == redSide) playerTurnLabel.setText("Player One's Turn");
                else playerTurnLabel.setText("Player Two's Turn");

                colOneButton.setDisable(false);
                colTwoButton.setDisable(false);
                colThreeButton.setDisable(false);
                colFourButton.setDisable(false);
                colFiveButton.setDisable(false);
                colSixButton.setDisable(false);
                colSevenButton.setDisable(false);

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        border[i][j].setImage(defaultBorder);
                    }
                }
            }

            // Re-enable menu options after alert exits
            backToMenu.setDisable(false);
            gameExit.setDisable(false);
            saveGame.setDisable(false);

        } else {
            boolean foundMove = false;
            for (int i = 0; i < 42; i++) {
                if (board[i % 6][i / 6].getImage() == blank) {
                    foundMove = true;
                }
            }

            if (!foundMove) {
                ties.setText(Integer.toString(Integer.parseInt(ties.getText()) + 1));

                colOneButton.setDisable(true);
                colTwoButton.setDisable(true);
                colThreeButton.setDisable(true);
                colFourButton.setDisable(true);
                colFiveButton.setDisable(true);
                colSixButton.setDisable(true);
                colSevenButton.setDisable(true);
                backToMenu.setDisable(true);
                gameExit.setDisable(true);
                saveGame.setDisable(true);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Tie!");
                alert.setHeaderText("Would you like to play again?");

                if (alert.showAndWait().get() == ButtonType.OK) {
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {
                            board[i][j].setImage(blank);
                        }
                    }

                    if (turnColor == redSide) playerTurnLabel.setText("Player One's Turn");
                    else playerTurnLabel.setText("Player Two's Turn");

                    colOneButton.setDisable(false);
                    colTwoButton.setDisable(false);
                    colThreeButton.setDisable(false);
                    colFourButton.setDisable(false);
                    colFiveButton.setDisable(false);
                    colSixButton.setDisable(false);
                    colSevenButton.setDisable(false);

                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {
                            border[i][j].setImage(defaultBorder);
                        }
                    }
                }

                // Re-enable menu options after alert exits
                backToMenu.setDisable(false);
                gameExit.setDisable(false);
                saveGame.setDisable(false);
            }
        }
    }

    // Exit menu option will provide an alert, exits the application on Confirm
    public void gameExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit the game.");
        alert.setContentText("Any unsaved data will be lost, do you still wish to exit?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) gameScene.getScene().getWindow();
            stage.close();
        }
    }

    // Switches to start menu
    public void switchToStartMenu(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        URL css = new URL("file:///" +
                new File("src/main/java/com/example/connectfour/").getAbsolutePath().replace("\\", "/") +
                "/application.css");
        scene.getStylesheets().add(css.toExternalForm());
        stage.show();
    }

    // Switches to the game
    public void switchToGameScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameScene.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        URL css = new URL("file:///" +
                new File("src/main/java/com/example/connectfour/").getAbsolutePath().replace("\\", "/") +
                "/application.css");
        scene.getStylesheets().add(css.toExternalForm());
        stage.show();
    }
    public void switchToHelpScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HelpScene.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        URL css = new URL("file:///" +
                new File("src/main/java/com/example/connectfour/").getAbsolutePath().replace("\\", "/") +
                "/application.css");
        scene.getStylesheets().add(css.toExternalForm());
        stage.show();
    }
    private int animationIncrement;
    public void dropPiece(boolean input) {
        if (input) {
            colOneButton.setDisable(true);
            colTwoButton.setDisable(true);
            colThreeButton.setDisable(true);
            colFourButton.setDisable(true);
            colFiveButton.setDisable(true);
            colSixButton.setDisable(true);
            colSevenButton.setDisable(true);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.04), e -> animationMethod())
            );
            animationIncrement = 0;
            populateWinCheckArray();
            int row = (lastPiece - 1) % 6;
            timeline.setCycleCount(row + 1);
            timeline.setOnFinished(e -> validMoveMade());
            timeline.play();
        }
    }
    public void animationMethod() {
        int col = (lastPiece - 1) / 6;
        if (animationIncrement > 0) {
            board[animationIncrement - 1][col].setImage(blank);
        }
        board[animationIncrement][col].setImage(turnColor);

        if (animationIncrement != 5) animationIncrement++;
    }
    public void mainMenuButtonSwap() {
        if (MainMenuButtonImage.getImage() == pressedButton) MainMenuButtonImage.setImage(unpressedButton);
        else MainMenuButtonImage.setImage(pressedButton);
    }
    public void exitGameButtonSwap() {
        if (ExitGameButtonImage.getImage() == pressedButton) ExitGameButtonImage.setImage(unpressedButton);
        else ExitGameButtonImage.setImage(pressedButton);
    }
    public void saveGameButtonSwap() {
        if (SaveGameButtonImage.getImage() == pressedButton) SaveGameButtonImage.setImage(unpressedButton);
        else SaveGameButtonImage.setImage(pressedButton);
    }
    public void newGameButtonSwap() {
        if (NewGameButtonImage.getImage() == pressedButton) NewGameButtonImage.setImage(unpressedButton);
        else NewGameButtonImage.setImage(pressedButton);
    }
    public void loadGameButtonSwap() {
        if (LoadGameButtonImage.getImage() == pressedButton) LoadGameButtonImage.setImage(unpressedButton);
        else LoadGameButtonImage.setImage(pressedButton);
    }
    public void helpMenuButtonSwap() {
        if (HelpMenuButtonImage.getImage() == pressedButton) HelpMenuButtonImage.setImage(unpressedButton);
        else HelpMenuButtonImage.setImage(pressedButton);
    }
    public void optionsMenuButtonSwap() {
        if (OptionsMenuButtonImage.getImage() == pressedButton) OptionsMenuButtonImage.setImage(unpressedButton);
        else OptionsMenuButtonImage.setImage(pressedButton);
    }
    public void menuExitGameButtonSwap() {
        if (MenuExitButtonImage.getImage() == pressedButton) MenuExitButtonImage.setImage(unpressedButton);
        else MenuExitButtonImage.setImage(pressedButton);
    }
}