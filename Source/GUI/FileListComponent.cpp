#include "FileListComponent.h"

#include "GuiConstants.h"

FileListComponent::FileListComponent()
{
    Song one = SongData{.title="Song Title 1", .artist="Artist 1"};
    Song two = SongData{.title="Song Title 2", .artist="Artist 2"};
    Song three = SongData{.title="Song Title 3", .artist="Artist 3"};
    songs_ = {
        one,
        two,
        three,
        // Add more songs as needed
    };

    tableModel_ = std::make_unique<FileListBoxModel>(songs_);
    tableListBox_.setModel(tableModel_.get());
    tableListBox_.getHeader().addColumn("Title", 1, 200);
    tableListBox_.getHeader().addColumn("Artist", 2, 200);

    addAndMakeVisible(tableListBox_);
}

void FileListComponent::paint(juce::Graphics &g)
{
    auto area = getLocalBounds();
    area.reduce(4, 4); // padding
    g.setColour(juce::Colours::ivory);
    g.fillRoundedRectangle(area.toFloat(), GuiConstant::CORNERN_RADIUS);
}
void FileListComponent::resized()
{
    auto area = getLocalBounds();
    area.reduce(8, 8); // padding
    tableListBox_.setBounds(area);
}
