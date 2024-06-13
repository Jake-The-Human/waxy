#include "ProfileView.h"
#include "GuiConstants.h"

ProfileView::ProfileView() {
    searchBox_.setEditable(true);
    searchBox_.setTooltip("Let get waxy with it.");
    searchBox_.setColour (juce::Label::backgroundColourId, juce::Colours::black);
    searchBox_.setHelpText("Search");
    addAndMakeVisible(searchBox_);
}

void ProfileView::paint(juce::Graphics& g) {
    auto area = getLocalBounds();
    area.reduce(4, 4);
    g.setColour(juce::Colours::ivory);
    g.fillRoundedRectangle(area.toFloat(), GuiConstant::CORNERN_RADIUS);
}

void ProfileView::resized() {
    auto area = getLocalBounds();
    area.reduce(32, 16);  // padding
    searchBox_.setBounds(area);
}
