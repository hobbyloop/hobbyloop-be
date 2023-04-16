package main

import (
	"encoding/json"
	"fmt"
	"github.com/bensch777/discord-webhook-golang"
	"io"
	"log"
	"net/http"
	"os"
	"time"
)

type HealthResponse struct {
	StatusMsg string `json:"status"`
}

func main() {
	var targetUrl = os.Getenv("INPUT_HEALTH_CHECK_URL")

	healthResponse, responseStatus, err := sendHTTPRequest(targetUrl)

	if responseStatus == 0 && err != nil {
		fmt.Println("sendHTTPRequest function Error:", err)
		os.Exit(1)
	}

	if responseStatus != 200 || healthResponse.StatusMsg != "UP" {

		embed := discordwebhook.Embed{
			Title:     "Example Webhook",
			Color:     15277667,
			Url:       "https://avatars.githubusercontent.com/u/6016509?s=48&v=4",
			Timestamp: time.Now(),
			Thumbnail: discordwebhook.Thumbnail{
				Url: "https://avatars.githubusercontent.com/u/6016509?s=48&v=4",
			},
			Author: discordwebhook.Author{
				Name:     "Author Name",
				Icon_URL: "https://avatars.githubusercontent.com/u/6016509?s=48&v=4",
			},
			Fields: []discordwebhook.Field{
				discordwebhook.Field{
					Name:   "Field 1",
					Value:  "Field Value 1",
					Inline: true,
				},
				discordwebhook.Field{
					Name:   "Field 2",
					Value:  "Field Value 2",
					Inline: true,
				},
				discordwebhook.Field{
					Name:   "Field 3",
					Value:  "Field Value 3",
					Inline: false,
				},
			},
			Footer: discordwebhook.Footer{
				Text:     "Footer Text",
				Icon_url: "https://avatars.githubusercontent.com/u/6016509?s=48&v=4",
			},
		}

		var webhookUrl = os.Getenv("DISCORD_URL")

		sendDiscordEmbed(healthResponse, responseStatus, webhookUrl, embed, err)
	}

}

func sendHTTPRequest(url string) (*HealthResponse, int, error) {
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, 0, err
	}

	client := http.DefaultClient
	resp, err := client.Do(req)
	if err != nil {
		return nil, 0, err
	}

	defer func(Body io.ReadCloser) {
		_ = Body.Close()
	}(resp.Body)

	if resp.StatusCode != http.StatusOK {
		downResponse := &HealthResponse{
			StatusMsg: "DOWN",
		}
		return downResponse, resp.StatusCode, fmt.Errorf("HTTP request failed with status code: %d", resp.StatusCode)
	}

	var responseJSON HealthResponse
	err = json.NewDecoder(resp.Body).Decode(&responseJSON)
	if err != nil {
		return nil, 0, err
	}

	return &responseJSON, resp.StatusCode, nil
}

func sendDiscordEmbed(healthResponse *HealthResponse, responseStatus int, link string, embeds discordwebhook.Embed, err error) error {

	hook := discordwebhook.Hook{
		Username:   "Captain Hook",
		Avatar_url: "https://avatars.githubusercontent.com/u/6016509?s=48&v=4",
		Content:    "Message",
		Embeds:     []discordwebhook.Embed{embeds},
	}

	payload, err := json.Marshal(hook)
	if err != nil {
		log.Fatal(err)
	}
	err = discordwebhook.ExecuteWebhook(link, payload)
	return err
}
