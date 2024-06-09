#include "DesktopGUI.h"

DesktopGUI::DesktopGUI() {
    addAndMakeVisible(profileView_);
    addAndMakeVisible(fileListView_);
    addAndMakeVisible(playlistView_);
}

void DesktopGUI::paint(juce::Graphics& g) {
    g.fillAll(juce::Colours::bisque);
}
void DesktopGUI::resized()
{
    auto area = getLocalBounds();

    auto profileHeight = 72;
    profileView_.setBounds(area.removeFromTop(profileHeight));
    fileListView_.setBounds(0, profileView_.getBottom(), area.getWidth() - (area.getWidth() / 3), area.getHeight());
    playlistView_.setBounds(fileListView_.getRight(), profileView_.getBottom(), (area.getWidth() / 3), area.getHeight());
}
