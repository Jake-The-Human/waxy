#include "FileListView.h"

FileListView::FileListView()
{
    songs_ = {
        {"Song Title 1", "Artist 1"},
        {"Song Title 2", "Artist 2"},
        {"Song Title 3", "Artist 3"},
        // Add more songs as needed
    };

    tableModel_ = std::make_unique<FileListBoxModel>(songs_);
    tableListBox_.setModel(tableModel_.get());
    tableListBox_.getHeader().addColumn("Title", 1, 200);
    tableListBox_.getHeader().addColumn("Artist", 2, 200);

    addAndMakeVisible(tableListBox_);
}

void FileListView::paint(juce::Graphics &g)
{
    g.fillAll(juce::Colours::rebeccapurple);
}
void FileListView::resized() {
    auto area = getLocalBounds();
    area.reduce(8, 8);  // padding
    tableListBox_.setBounds(area);
}
