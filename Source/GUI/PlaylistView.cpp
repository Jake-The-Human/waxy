#include "PlaylistView.h"

#include "GuiConstants.h"

PlaylistView::PlaylistView() {
    playlistListBox_.setModel(&playlistBoxModel_);
    addAndMakeVisible(playlistListBox_);
    addAndMakeVisible(nowPlayingView_);
}

void PlaylistView::paint(juce::Graphics& g) {
    auto area = getLocalBounds();
    area.reduce(4, 4);
    g.setColour(juce::Colours::ivory);
    g.fillRoundedRectangle(area.toFloat(), GuiConstant::CORNERN_RADIUS);
}
void PlaylistView::resized() {
    auto area = getLocalBounds();
    area.reduce(8, 8);  // padding
    nowPlayingView_.setBounds(area.removeFromBottom(area.getHeight() / 3));
    playlistListBox_.setBounds(area);
}
