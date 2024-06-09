#include "ProfileView.h"


ProfileView::ProfileView() {
    profileName_.setText("Waxy", juce::dontSendNotification);
    profileName_.setJustificationType(juce::Justification::left);
    profileName_.setTooltip("Let get waxy with it.");
    addAndMakeVisible(profileName_);
}

void ProfileView::paint(juce::Graphics& g) {
    g.fillAll(juce::Colours::darkblue);
}

void ProfileView::resized() {
    auto area = getLocalBounds();
    area.reduce(8, 8);  // padding
    profileName_.setBounds(area);
}
