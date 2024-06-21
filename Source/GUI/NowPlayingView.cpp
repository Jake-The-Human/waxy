#include "NowPlayingView.h"
#include "../Logic/WaxyState.h"
#include "GuiConstants.h"

constexpr auto PLAY = "Play";
constexpr auto PAUSE = "Pause";

NowPlayingView::NowPlayingView(std::shared_ptr<WaxyState> waxyState)
    : waxyState_(waxyState)
{
    waxyState_->addChangeListener(this);
    nowPlayingLabel_.setText("Now Playing", juce::dontSendNotification);
    nowPlayingLabel_.setJustificationType(juce::Justification::topLeft);
    addAndMakeVisible(nowPlayingLabel_);

    currentSongLabel_.setText("Curent Song:", juce::dontSendNotification);
    currentSongLabel_.setJustificationType(juce::Justification::topLeft);
    addAndMakeVisible(currentSongLabel_);

    playButton_.setButtonText(PLAY);
    playButton_.addListener(this);
    addAndMakeVisible(playButton_);

    nextButton_.setButtonText("Next");
    addAndMakeVisible(nextButton_);

    prevButton_.setButtonText("Prev");
    addAndMakeVisible(prevButton_);
}

void NowPlayingView::paint(juce::Graphics &g)
{
    auto area = getLocalBounds();
    g.setColour(juce::Colours::green);
    g.fillRoundedRectangle(area.toFloat(), GuiConstant::CORNERN_RADIUS);
    SongData curSong = waxyState_->getCurrentSong();
    currentSongLabel_.setText("Curent Song:" + curSong.title, juce::dontSendNotification);
}

void NowPlayingView::resized()
{
    auto area = getLocalBounds();
    area.reduce(8, 8); // padding
    auto fourthHeight= area.getHeight() / 4;
    auto thirdWidth = area.getWidth() / 3;
    nowPlayingLabel_.setBounds(area.removeFromTop(fourthHeight));
    currentSongLabel_.setBounds(area.removeFromTop(fourthHeight));
    nextButton_.setBounds(area.removeFromLeft(thirdWidth));
    playButton_.setBounds(area.removeFromLeft(thirdWidth));
    prevButton_.setBounds(area.removeFromLeft(thirdWidth));
}

void NowPlayingView::changeListenerCallback(juce::ChangeBroadcaster *source)
{
    if (source == waxyState_.get()) {
        currentSongLabel_.repaint();
    }
}

void NowPlayingView::buttonClicked(juce::Button *button)
{
    if (button == &playButton_)
    {
        if (playButton_.getButtonText() == PLAY && waxyState_->isPlaying())
        {
            playButton_.setButtonText(PAUSE);
            waxyState_->changeState(TransportState::Stopping);
        }
        else if (playButton_.getButtonText() == PAUSE)
        {
            playButton_.setButtonText(PLAY);
            waxyState_->changeState(TransportState::Starting);
        }
    }
}
