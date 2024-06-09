#pragma once

#include <deque>

#include <JuceHeader.h>

class PlayListBoxModel :
    public juce::ListBoxModel
{
public:
    // juce::ListBoxModel
    int getNumRows() override;
    void paintListBoxItem(int rowNumber, juce::Graphics& g, int width, int height, bool rowIsSelected) override;
private:
    std::deque<std::string> songs_;
};
