#include "NowPlayingView.h"
#include "../Logic/WaxyState.h"
#include "GuiConstants.h"

constexpr auto PLAY = "Play";
constexpr auto PAUSE = "Pause";

NowPlayingView::NowPlayingView(std::shared_ptr<WaxyState> waxyState)
    : waxyState_(waxyState) {
  playButton_.setButtonText(PLAY);
  playButton_.addListener(this);
  addAndMakeVisible(playButton_);
  nextButton_.setButtonText("Next");
  addAndMakeVisible(nextButton_);
  prevButton_.setButtonText("Prev");
  addAndMakeVisible(prevButton_);
}

void NowPlayingView::paint(juce::Graphics &g) {
  auto area = getLocalBounds();
  g.setColour(juce::Colours::green);
  g.fillRoundedRectangle(area.toFloat(), GuiConstant::CORNERN_RADIUS);
}

void NowPlayingView::resized() {
  auto area = getLocalBounds();
  area.reduce(8, 8); // padding
  auto thirdWidth = area.getWidth() / 3;
  nextButton_.setBounds(area.removeFromLeft(thirdWidth));
  playButton_.setBounds(area.removeFromLeft(thirdWidth));
  prevButton_.setBounds(area.removeFromLeft(thirdWidth));
}

void NowPlayingView::buttonClicked(juce::Button *button) {
  if (button == &playButton_) {
    if (playButton_.getButtonText() == PLAY && waxyState_->isPlaying()) {
      playButton_.setButtonText(PAUSE);
      waxyState_->changeState(TransportState::Stopping);
    } else if (playButton_.getButtonText() == PAUSE) {
      playButton_.setButtonText(PLAY);
      waxyState_->changeState(TransportState::Starting);
    }
  }
}
