#include "PlaylistView.h"

PlaylistView::PlaylistView() {
    addAndMakeVisible(nowPlayingView_);
}

void PlaylistView::paint(juce::Graphics& g) {
    g.fillAll(juce::Colours::firebrick);
}
void PlaylistView::resized() {
    auto area = getLocalBounds();
    nowPlayingView_.setBounds(area.removeFromBottom(area.getHeight() / 3));

}
