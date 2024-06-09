#include "ProfileView.h"


ProfileView::ProfileView() {
}

void ProfileView::paint(juce::Graphics& g) {
    g.fillAll(juce::Colours::aqua);
}

void ProfileView::resized() {
    auto area = getLocalBounds();
}
