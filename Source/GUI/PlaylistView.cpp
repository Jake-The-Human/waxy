#include "PlaylistView.h"

PlaylistView::PlaylistView() {
    playlistListBox_.setModel(&playlistBoxModel_);
    addAndMakeVisible(playlistListBox_);
    addAndMakeVisible(nowPlayingView_);
}

void PlaylistView::paint(juce::Graphics& g) {
    g.fillAll(juce::Colours::firebrick);
}
void PlaylistView::resized() {
    auto area = getLocalBounds();
    area.reduce(8, 8);  // padding
    nowPlayingView_.setBounds(area.removeFromBottom(area.getHeight() / 3));
    playlistListBox_.setBounds(area);
}
