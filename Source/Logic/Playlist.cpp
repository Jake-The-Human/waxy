

#include "Playlist.h"

int PlayListBoxModel::getNumRows()
{
    return songs_.size(); // Number of items in the list
}

void PlayListBoxModel::paintListBoxItem(int rowNumber, juce::Graphics& g, int width, int height, bool rowIsSelected)
{
    if (rowIsSelected)
        g.fillAll(juce::Colours::lightblue);

    g.setColour(juce::Colours::black);
    g.setFont(height * 0.7f);
    g.drawText("Item " + juce::String(rowNumber + 1), 5, 0, width, height, juce::Justification::centredLeft, true);
}