#pragma once

#include <JuceHeader.h>
#include "FileListBoxModel.h"

#include <memory>

class FileListView : public juce::Component
{
public:
    virtual ~FileListView() = default;
    FileListView();
    FileListView(const FileListView &) = default;
    FileListView(FileListView &&) = default;

    FileListView &operator=(const FileListView &) = default;
    FileListView &operator=(FileListView &&) = default;

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    juce::TableListBox tableListBox_;
    std::vector<Song> songs_;
    std::unique_ptr<FileListBoxModel> tableModel_;
};
