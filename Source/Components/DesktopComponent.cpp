#include "DesktopComponent.h"
#include "PlaylistComponent.h"

DesktopComponent::DesktopComponent(std::shared_ptr<WaxyState> waxyState) : playlistView_(waxyState)
{
    addAndMakeVisible(profileView_);
    addAndMakeVisible(fileListView_);
    addAndMakeVisible(playlistView_);
}

void DesktopComponent::paint(juce::Graphics &g) {}

void DesktopComponent::resized()
{
    auto area = getLocalBounds();

    auto profileHeight = 72;
    profileView_.setBounds(area.removeFromTop(profileHeight));
    fileListView_.setBounds(area.removeFromLeft(area.getWidth() - (area.getWidth() / 3)));
    playlistView_.setBounds(area.removeFromLeft(area.getWidth()));
}
