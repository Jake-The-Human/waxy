#include "NowPlayingView.h"
#include "GuiConstants.h"

constexpr auto PLAY = "Play";
constexpr auto PAUSE = "Pause";

NowPlayingView::NowPlayingView() {
    playButton_.setButtonText(PLAY);
    playButton_.addListener(this);
    addAndMakeVisible(playButton_);
    nextButton_.setButtonText("Next");
    addAndMakeVisible(nextButton_);
    prevButton_.setButtonText("Prev");
    addAndMakeVisible(prevButton_);
}

void NowPlayingView::paint(juce::Graphics& g) {
    auto area = getLocalBounds();
    g.setColour(juce::Colours::green);
    g.fillRoundedRectangle(area.toFloat(), GuiConstant::CORNERN_RADIUS);
}
void NowPlayingView::resized() {
    auto area = getLocalBounds();
    area.reduce(8, 8);  // padding
    auto thirdWidth = area.getWidth() / 3;
    nextButton_.setBounds(area.removeFromLeft(thirdWidth));
    playButton_.setBounds(area.removeFromLeft(thirdWidth));
    prevButton_.setBounds(area.removeFromLeft(thirdWidth));
}

void NowPlayingView::buttonClicked(juce::Button* button)
{
    if (button == &playButton_) {
        if (playButton_.getButtonText() == PLAY) {
            playButton_.setButtonText(PAUSE);
        }
        else {  // Pause
            playButton_.setButtonText(PLAY);
        }
    }
}
