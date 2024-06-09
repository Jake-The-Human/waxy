#include "DesktopGUI.h"

DesktopGUI::DesktopGUI() {
    addAndMakeVisible(profileView_);
    addAndMakeVisible(fileListView_);
    addAndMakeVisible(playlistView_);
}

void DesktopGUI::paint(juce::Graphics& g) {}

void DesktopGUI::resized()
{
    auto area = getLocalBounds();

    auto profileHeight = 72;
    profileView_.setBounds(area.removeFromTop(profileHeight));
    fileListView_.setBounds(area.removeFromLeft(area.getWidth() - (area.getWidth() / 3)));
    playlistView_.setBounds(area.removeFromLeft(area.getWidth()));
}
